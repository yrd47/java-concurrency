package chapter3.chapter3_3;

/**
 * 资源的多副本的并发访问控制
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[12];
        for (int i = 0; i < 12; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
            threads[i].start();
        }
    }
}
