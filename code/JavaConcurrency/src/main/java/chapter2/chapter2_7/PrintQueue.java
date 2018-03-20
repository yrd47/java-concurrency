package chapter2.chapter2_7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yrd on 2018/3/20.
 */
public class PrintQueue {

    /**
     * 用于控制队列访问的锁，使用公平锁
     */
    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object object) {
        queueLock.lock();           //上锁
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();     //解锁
        }

        queueLock.lock();           //上锁
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();     //解锁
        }
    }
}
