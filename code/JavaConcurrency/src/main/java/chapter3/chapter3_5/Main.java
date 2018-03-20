package chapter3.chapter3_5;

import java.util.concurrent.CyclicBarrier;

/**
 * 在集合点的同步
 *
 * Java并发API提供了 CycleBarrie类，它也是一个同步辅助类。它允许两个或者多个线程在某个点上进行同步
 *
 * CycleBarrie类使用一个整型数进行初始化，这个数是需要在某个点上同步的线程数。当一个线程到达指定的点后，它将调用await()方法等待其他的线程。
 * 当线程调用mvait()方法后，CycleBarrie类将阻塞这个线程并使之休眠直到所有其他线程到达。
 * 当最后一个 线程调用CycleBarrie类的await()方法时，CycleBarrie对象将唤醒所有在等待的线程，然后这些线程将继续执行
 *
 * 它可以传入另一个Runnable对象作为初始化参数，当所有的线程都到达集合点后，CycleBarrie类将这个Runnable对象作为线程执行
 *
 * CyclicBarrieir类有一个内部计数器，可以控制指定数目的几个线程必 须都到达集合点。每一个线程到达集合点后就会调用await()方法通知CyclicBarrier对象, CyclicBarrier对象会让这个线程休眠直到其他所有的线程都到达集合点
 *
 * CyclicBarrier对象可以被重置回初始状态，并把它的内部计数器重置成初始化时的值
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        final int ROWS = 10000; // 矩阵的行数
        final int NUMBERS = 1000; // 矩阵的列数
        final int SEARCH = 5; // 要查询的数字
        final int PARTICIPANTS = 5; // 查询线程的个数
        final int LINES_PARTICIPANT = 2000; // 每个查询线程处理的行数
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH); // 创建矩阵模拟对象
        Results results = new Results(ROWS); // 创建结果对象
        Grouper grouper = new Grouper(results); // 创建组合对象

        // 创建一个同步栅对象，它有5个参与者， 5个参与者线程完成后，会调用grouper中的run方法
        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTICIPANTS, grouper);

        // 创建5个参与者对象，并且让它们各自在单独的线程中运行
        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i = 0; i < searchers.length; i++) {
            searchers[i] = new Searcher(cyclicBarrier, i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT,
                    mock, results, PARTICIPANTS);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
