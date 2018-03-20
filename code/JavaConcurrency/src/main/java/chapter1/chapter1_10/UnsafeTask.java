package chapter1.chapter1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程不安全任务，当这个任务在多线程中时，其中的变量会被多个线程共享
 * Created by yrd on 2017/11/23.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread finnish : %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}
