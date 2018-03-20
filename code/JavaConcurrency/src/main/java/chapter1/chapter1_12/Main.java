package chapter1.chapter1_12;

/**
 * Created by yrd on 2018/3/7.
 */
public class Main {

    public static void main(String[] args) {
        // 创建一个自定义的线程组
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        // 创建一个任务
        Task task = new Task();
        // 创建两个线程，将其放入同一个线程组中，并且执行同一个任务
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(myThreadGroup, task);
            t.start();
        }
    }
}
