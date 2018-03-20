package chapter3.chapter3_2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 打印队列类，使用信号量来控制打印作业的访问
 *
 * Created by yrd on 2018/3/20.
 */
public class PrintQueue {

    /**
     * 信号量，控制队列的访问
     */
    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object object) {
        try {
            // 请求信号量，如果已经被其它线程请求过，则当前请求的线程会休眠，直到获得这个信号量
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放信号量，如果有其它的线程在请求这个信号量，JVN会选择其中的某一个程获取信号量，让其运行
            semaphore.release();
        }
    }
}
