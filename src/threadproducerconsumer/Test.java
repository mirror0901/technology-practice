package threadproducerconsumer;

/**
 * @author: mirror
 * @date: 2020/4/27 14:53
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        ProducerThread producerThread = new ProducerThread();
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread();
        consumerThread.start();
    }

}
