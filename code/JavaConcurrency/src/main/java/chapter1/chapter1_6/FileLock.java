package chapter1.chapter1_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/6.
 * 文件定时类，每隔一秒钟将实际的时间输出
 */
public class FileLock implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileLock has been interrupted\n");
                return;
            }
        }
    }
}
