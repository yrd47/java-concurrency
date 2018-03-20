package chapter2.chapter2_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列类，模拟一个打印队列事件
 *
 * Created by yrd on 2018/3/20.
 */
public class PrintQueue {

    /**
     * 用于控制队列访问的锁
     */
    private final Lock lock = new ReentrantLock();

    public void printJob(Object object) {
        lock.lock();    //上锁
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //解锁
        }
    }
}
