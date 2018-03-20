package chapter1.chapter1_5;

import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/5.
 */
public class Main {

    /**
     * 递归太多导致栈空间溢出
     * @param args
     */
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("/Users/yrd/Learning/java-concurrency/code/JavaConcurrency", "result.txt");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
