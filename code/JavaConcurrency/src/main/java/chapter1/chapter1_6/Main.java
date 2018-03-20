package chapter1.chapter1_6;

import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/6.
 */
public class Main {

    public static void main(String[] args) {
        FileLock fileLock = new FileLock();
        Thread thread = new Thread(fileLock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
