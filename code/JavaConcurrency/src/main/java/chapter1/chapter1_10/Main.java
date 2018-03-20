package chapter1.chapter1_10;

import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2017/11/23.
 */
public class Main {

    /**
     * 线程局部变量 ThreadLocal<></>
     *
     * unsafeTask的每个线程有不同的开始值，但结束时有相同的startDate属性值
     *
     * @param args
     */
    public static void main(String[] args) {

        UnsafeTask unsafeTask = new UnsafeTask();
        SafeTask safeTask = new SafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------------");

        for (int i = 0; i < 3; i++) {
            Thread thread1 = new Thread(safeTask);
            thread1.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
