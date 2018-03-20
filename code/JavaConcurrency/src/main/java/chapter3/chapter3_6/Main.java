package chapter3.chapter3_6;

import java.util.concurrent.Phaser;

/**
 * 并发阶段任务的运行
 *
 * Phaser：允许执行并发多阶段任务   Phaser类机制是在每一步结束的位置对线程进行同步，当所有的线程都完成了这一步，才允许执行下一步
 *
 * 必须对Phaser类中参与同步操作的任务数进行初始化，不同的是，我们可以动态地增加或者减少任务数
 *
 * 一个Phaser对象有两种状态。

 ♦活跃态（Active):当存在参与同步的线程的时候，Phaser就是活跃的，并且在每个阶段结束的时候进行同步。在这种状态中，Phaser的执行如前文所述。但在Java并发 API中并没有提到这种状态。

 ♦终止态（Termination):当所有参与同步的线程都取消注册的时候，Phaser就处于终止状态，在这种状态下，Phaser没有任何参与者。
 更具体地说，当Phaser对象的 onAdvance()方法返回true的时候，Phaser对象就处于了终止态。通过覆盖这个方法可以 改变默认的行为。当Phaser是终止态的时候，同步方法arriveAndAwaitAdvance()会立即返回，而且不会做任何同步的操作。
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        //创建一个阶段对象，它有三个参与者
        Phaser phaser = new Phaser(3);

        // 创建一个文件搜索对象，每一个搜索不同的目录
        FileSearch fileSearch1 = new FileSearch("/Users/yrd/Learning/java-concurrency/code/JavaConcurrency/src/main/java/chapter3/chapter3_1", "java", phaser);
        FileSearch fileSearch2 = new FileSearch("/Users/yrd/Learning/java-concurrency/code/JavaConcurrency/src/main/java/chapter3/chapter3_2", "java", phaser);
        FileSearch fileSearch3 = new FileSearch("/Users/yrd/Desktop/w3school/html", "java", phaser);

        Thread thread1 = new Thread(fileSearch1, "f1");
        thread1.start();

        Thread thread2 = new Thread(fileSearch2, "f2");
        thread2.start();

        Thread thread3 = new Thread(fileSearch3, "f3");
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Terminated: %s\n", phaser.isTerminated());
    }
}
