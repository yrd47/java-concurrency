package chapter1.chapter1_7;

import java.util.Date;

/**
 * Created by yrd on 2018/3/6.
 */
public class Main {

    /**
     * join() 等待调用join的线程执行完成
     * @param args
     */
    public static void main(String[] args) {
        DataSourceLoader dataSourceLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dataSourceLoader, "DataSourceThread");
        NetworkConnectionLoader networkConnectionLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(networkConnectionLoader, "NetworkConnectionLoader");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
    }
}
