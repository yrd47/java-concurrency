package chapter2.chapter2_4;

/**
 * 在同步代码中使用条件
 * 生产者-消费者问题
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();

        Producer producer = new Producer(eventStorage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(eventStorage);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
