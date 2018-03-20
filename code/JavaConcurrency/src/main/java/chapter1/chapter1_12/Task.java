package chapter1.chapter1_12;

import java.util.Random;

/**
 * Created by yrd on 2018/3/7.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            // 生成一个[0, 1000)内有随机整数，并且有1000除以这个数，求得商
            result = 1000 / ((int) (random.nextDouble() * 1000));
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
            // 检测当前线程是否被中断
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
