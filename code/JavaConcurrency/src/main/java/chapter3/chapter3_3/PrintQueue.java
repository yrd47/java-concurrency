package chapter3.chapter3_3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列对象，它可以访问三台打印机，使用信号量来控制打印机的访问，当有一个打印作业，
 * 如果有空闲的打印杨就将作业分配到某个打印机上，否则就等待打印机空闲，再分配打印机
 *
 * Created by yrd on 2018/3/20.
 */
public class PrintQueue {

    /**
     * 资源信号量，控制打印机的访问
     */
    private Semaphore semaphore;
    /**
     * 标记打印机是否空闲的数组
     */
    private boolean[] freePrinters;
    /**
     * 锁，控制打印机是否空闲的数组的访问
     */
    private Lock lockPrinters;

    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < freePrinters.length; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object object) {
        try {
            // 请求信号量，如果有一个打印机是空闲的，就会访问其中一个空闲的打印机
            semaphore.acquire();

            //获取分配的打印机编号
            int assignedPrinter = getPrinter();

            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {
            // 获取打印机状态数组的访问能力
            lockPrinters.lock();
            // 查找第一个空闲的打印机
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }

}
