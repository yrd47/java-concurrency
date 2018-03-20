package chapter2.chapter2_5;

/**
 * 使用锁实现同步
 *
 * 基于Lock接口及其实现类（如ReemrantLock）
 * 支持更灵活的同步代码块结构
 * Lock接口提供了更多的功能   tryLock()
 * Lock接口允许分离读和写操作，允许多个读线程和只有一个写线程
 * Lock接口具有更好的性能
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Job job = new Job(printQueue);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(job, "Thread " + 1);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
