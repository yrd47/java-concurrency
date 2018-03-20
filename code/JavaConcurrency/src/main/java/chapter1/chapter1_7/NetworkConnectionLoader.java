package chapter1.chapter1_7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/6.
 */
public class NetworkConnectionLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning network connection loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data network connection has finished: %s\n", new Date());
    }
}
