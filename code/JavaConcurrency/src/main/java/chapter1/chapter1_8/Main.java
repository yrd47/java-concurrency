package chapter1.chapter1_8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yrd on 2018/3/6.
 */
public class Main {

    /**
     * 守护线程
     * @param args
     */
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();

        WriteTask writeTask = new WriteTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writeTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
