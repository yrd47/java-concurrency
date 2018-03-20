package chapter3.chapter3_4;

/**
 * 等待多个并发事件的完成
 *
 * Java并发API提供了CountDownLatch类，它是一个同步辅助类。在完成一组正在其他线程中执行的操作之前，它允许线程一直等待。
 * 这个类使用一个整数进行初始化，这个整数就是线程要等待完成的操作的数目。当一个线程要等待某些操作先执行完时，需要调用await()方法，这个方法让线程进入体眠直到等待的所有操作都完成。
 * 当某一个操作完成后，它将调用countDown()方法将CountDownLatch类的内部计数器减1。当计数器变成0的时候，CountDownLatch类将唤醒所有调用await()方法而进入休眠的线程
 *
 * CountDownLatch类有三个基本元素；

 　　♦ 一个初始值，

 　　♦ await() 方法，

 　　♦ countdown()方法，
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        // 创建一个视频会议对象，它有10个参与者
        VideoConference conference = new VideoConference(10);
        // 创建一个线程去运行视频会议
        Thread threadConference = new Thread(conference);
        threadConference.start();

        // 创建十个参与者，每个参与者在一个单独的线程中运行
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
