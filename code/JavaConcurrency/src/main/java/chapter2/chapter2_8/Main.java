package chapter2.chapter2_8;

/**
 * 在锁中使用多条件
 * <p>
 * 一个锁可能关联一个或者多个条件，这些条件通过Condition接口声明。
 * 目的是允许线程获取锁并且査看等待的某一个条件是否满足，如果不满足就挂起直到某个线程唤醒它们。Condition接口提供了挂起线程和唤起线程的机制
 * <p>
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        FileMock mock = new FileMock(101, 10);

        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] threadConsumers = new Thread[3];

        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
        }

        // 启动生产者和消费者线程
        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}
