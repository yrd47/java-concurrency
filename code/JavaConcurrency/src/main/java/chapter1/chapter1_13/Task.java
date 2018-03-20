package chapter1.chapter1_13;

import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/7.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
