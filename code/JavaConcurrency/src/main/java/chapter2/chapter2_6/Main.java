package chapter2.chapter2_6;

/**
 * 使用读写锁实现同步数剧访问
 *
 * 锁机制最大的改进之一就是ReadWriteLock接口和它的唯一实现类ReentrantRead WriteLock。
 * 这个类有两个锁，一个是读操作锁，另一个是写操作锁。
 * 使用读操作锁时可 以允许多个线程同时访问，但是使用写操作锁时只允许一个线程进行。
 * 在一个线程执行写 操作时，其他线程不能够执行读操作
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();

        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[5];

        // 创建5个读者并且将其放在不同的线程中远行
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        // 创建一个写者，并且将其放在一个线程中运行
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        // 启动读者写者线程
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
