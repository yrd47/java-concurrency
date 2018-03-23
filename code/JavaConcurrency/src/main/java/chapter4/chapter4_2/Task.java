package chapter4.chapter4_2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 任务类
 *
 * Created by yrd on 2018/3/23.
 */
public class Task implements Runnable {

    /**
     * 任务创建的时间
     */
    private Date initDate;
    /**
     * 任务的名称
     */
    private String name;

    public Task(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}
