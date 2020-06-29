package com.mirror.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: mirror
 * @date: 2020/6/10 16:00
 * @description:
 */
@Component
public class SmsListener implements ApplicationListener<OrderEvent> {

    @Async
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println(Thread.currentThread() + "...邮件监听到..." + orderEvent.getMessage() + "..." + orderEvent.getSource());
    }

}
