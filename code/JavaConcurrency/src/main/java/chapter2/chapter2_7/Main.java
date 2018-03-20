package chapter2.chapter2_7;

/**
 * 修改锁的公平性
 *
 * ReentrantLock和ReentrantReadWriteLock类的构造器都含有一个布尔参数fair，它允许你控制这两个类的行为。
 * 默认fair的值是false,它称为非公平模式（Non-Fair Mode)。
 * 在非公平模式下，当有很多线程在等待锁（ReentrantLock和ReentrantReadWriteLock）时，锁将选择它们中的一个来访问临界区,这个选择是没有任何约束的。
 * 如果fail的值是true, 则称为公平模式（Fair Mode)。在公平模式下，当有很多线程在等待锁（ReentrantLock和ReentrantReadWriteLock）时，锁将选择它们中的一个来访问临界区，而且选择的是等待时间最长的
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        // 创建10个打印任务并且将其放入到不同的线程中运行
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // 每隔0.1s运行一个线程，一个10个线程
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
