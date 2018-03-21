package chapter3.chapter3_7;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/21.
 */
public class Studen implements Runnable {

    private Phaser phaser;

    public Studen(Phaser phaser) {
        this.phaser = phaser;
    }

    /**
     * 核心方法，进入考试状态，做三个测试题，每做完一个测试题，它调用阶段对象等待所有其的学生都完成同样的测试题
     */
    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the first exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise1();
        System.out.printf("%s: Has done the first exercise. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the second exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: Has done the second exercise. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the third exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise3();
        System.out.printf("%s: Has finished the exam. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * 做一个测试题，并且休眠[0, 10)秒
     */
    private void doExercise1() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 做一个测试题，并且休眠[0, 10)秒
     */
    private void doExercise2() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 做一个测试题，并且休眠[0, 10)秒
     */
    private void doExercise3() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
