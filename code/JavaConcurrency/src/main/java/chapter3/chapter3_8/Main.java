package chapter3.chapter3_8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 并发任务间的数据交换
 *
 * Exchanger    允许在并发任务之间交换数据
 * Exchanger类允许在两个线程之间定义同步点（Synchronization Point)。当两个线程都到达同步点时，它们交换数据结构，因此第一个线程的数据结构进入到第二个线程中，同时第二个线程的数据结构进入到第一个线程中
 *
 * Created by yrd on 2018/3/21.
 */
public class Main {

    public static void main(String[] args) {
        // 创建两个缓存对象
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        // 创建一个交换器对象
        Exchanger<List<String>> exchanger = new Exchanger<>();

        // 创建生产者对象
        Producer producer = new Producer(exchanger, buffer1);
        // 创建消费者对象
        Consumer consumer = new Consumer(exchanger, buffer2);

        // 创建消费者对象和生产者对象放置在不同的线程中
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        // 启动两个线程
        threadProducer.start();
        threadConsumer.start();
    }
}
