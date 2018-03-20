package chapter1.chapter1_11;

import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2018/3/7.
 */
public class Main {

    /**
     * ThreadGroup
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个线程组
        ThreadGroup threadGroup = new ThreadGroup("Searcher");

        Result result = new Result();
        // 创建一个搜索任务，并且创建5个线程去运行这个任务
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0 ; i < 5; i++) {
            //第一个参数是ThreadGroup对象
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        waitFinish(threadGroup);
    }

    /**
     * 等待线程组中的一个线程结束
     *
     * @param threadGroup 线程组
     */
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
