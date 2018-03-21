package chapter3.chapter3_7;

/**
 * Phaser类提供了 onAdvance()方法，它在phaser阶段改变的时候会被自动执行。
 * onAdvance()方法需要两个int型的传入参数：当前的阶段数以及注册的参与者数量。它返回的是boolean值，如果返回false表示phaser在继续执行，返回true表示phaser已经经完成执行并且进入了终止态
 *
 * Created by yrd on 2018/3/21.
 */
public class Main {

    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();

        Studen[] students = new Studen[5];
        for (int i = 0; i < 5; i++) {
            students[i] = new Studen(phaser);
            phaser.register();
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 检查阶段是否已经到达完成状态
        System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());
    }
}
