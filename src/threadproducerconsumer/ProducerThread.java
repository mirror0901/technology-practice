package threadproducerconsumer;

/**
 * @author: mirror
 * @date: 2020/4/27 14:40
 * @description:生产者
 */
public class ProducerThread extends Thread {

    /**
     * 仓库容量为100
     */
    public static OrderStorage orderStorage = new OrderStorage(100);

    @Override
    public void run() {
        int i = 1;
        while (true) {
            Order order = new Order(i);

            try {
                orderStorage.push(order);
                System.out.println("已生产编号为" + i + "的订单");
                //降低速度,方便看效果
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

}
