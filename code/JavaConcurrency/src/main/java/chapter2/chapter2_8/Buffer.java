package chapter2.chapter2_8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yrd on 2018/3/20.
 */
public class Buffer {

    /**
     * 集合对象，被当作缓冲使用
     */
    private LinkedList<String> buffer;
    /**
     * 缓冲的最大大小
     */
    private int maxSize;
    /**
     * 控制缓冲访问的锁
     */
    private ReentrantLock lock;
    /**
     * 缓冲中有数据的条件
     */
    private Condition lines;
    /**
     * 缓冲为空的条件
     */
    private Condition space;
    /**
     * 是否追加行
     */
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        this.buffer = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }

    /**
     * 向缓冲区中插入一行数据
     *
     * @param line 一行数据
     */
    public void insert(String line) {
        lock.lock();
        try {
            while (this.buffer.size() == this.maxSize) {
                this.space.await();
            }
            //等待空位出现
            this.buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), this.buffer.size());
            this.lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String line = null;
        lock.lock();
        try {
            while (this.buffer.size() == 0 && hasPendingLines()) {
                this.lines.await();
            }

            if (hasPendingLines()) {
                line = this.buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), this.buffer.size());
                this.space.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }

        return line;
    }

    /**
     * 设置是否追加行
     *
     * @param pendingLines true追加，false不追加
     */
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    /**
     * 判断是否有数据可以进行处理
     *
     * @return true有数据可进行处理，false无数据可以进行处理
     */
    public boolean hasPendingLines() {
        return this.pendingLines || this.buffer.size() > 0;
    }
}
