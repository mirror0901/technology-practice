package threadproducerconsumer;

/**
 * @author: mirror
 * @date: 2020/4/27 14:47
 * @description:消费者
 */
public class ConsumerThread extends Thread {

    /**
     * 消费者和生产者使用的要是同一个仓库
     */
    private OrderStorage orderStorage = ProducerThread.orderStorage;

    @Override
    public void run() {
        while (true) {
            try {
                //如果仓库中没有Order,会阻塞当前线程,知道有Order可以弹出
                Order order = orderStorage.pop();
                System.out.println("已消费|处理编号为" + order.getId() + "的订单");
                //降低速度,方便看效果
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
