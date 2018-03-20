package chapter1.chapter1_13;

/**
 * Created by yrd on 2018/3/7.
 */
public class Main {

    public static void main(String[] args) {
        //创建一个线程工厂
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;

        //// 创建并且启动10个线程对象
        System.out.printf("Starting the threads\n");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats: \n");
        System.out.printf("%s\n", factory.getStats());
    }
}
