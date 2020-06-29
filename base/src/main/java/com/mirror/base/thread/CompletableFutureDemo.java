package com.mirror.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println(future.get().toString());
        System.out.println("finish!");

        //4
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> i + 1)
                .thenApply(i -> i * i)
                .whenComplete((r, e) -> System.out.println(r));

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase);

        //thenCombine整合两个计算结果
        //此阶段与其它阶段一起完成,进而触发下一阶段
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + "World")
                .thenApply(String::toUpperCase)
                .thenCombine(CompletableFuture.completedFuture("Java"),
                        (s1, s2) -> s1 + s2)
                .thenAccept(System.out::println);

        //whenComplete
        String[] list = {"a", "b", "c"};
        List<CompletableFuture> resultList = new ArrayList<>();
        for (String str : list) {
            resultList.add(CompletableFuture.supplyAsync(() -> str)
                    .thenApply(e -> e.toUpperCase()));
        }

        CompletableFuture[] completableFutures = resultList.stream()
                .map((t) -> CompletableFuture.supplyAsync(() -> t))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(resultList.toArray(new CompletableFuture[resultList.size()]))
                .whenComplete((r, e) -> {
                    if (null == e) {
                        System.out.println("所有任务完成");
                    } else {
                        throw new RuntimeException(e);
                    }
                });
        CompletableFuture.anyOf(resultList.toArray(new CompletableFuture[resultList.size()]))
                .whenComplete((r, e) -> {
                    if (null == e) {
                        System.out.println("单个任务完成");
                    } else {
                        throw new RuntimeException(e);
                    }
                }).join();

        List<Object> collect = resultList.stream().map(item -> {
            try {
                return item.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        System.out.println(collect);

    }

}
