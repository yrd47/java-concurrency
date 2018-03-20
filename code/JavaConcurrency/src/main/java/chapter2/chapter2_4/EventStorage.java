package chapter2.chapter2_4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 事件存储类，生产者会存储事件，消费者会处理存储的事件，一个事件就是一个日期对象
 *
 * Created by yrd on 2018/3/20.
 */
public class EventStorage {
    /**
     * 最多可以保存的事件数
     */
    private int maxSize;

    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    /**
     * 同步方法，向事件集合中添加一个事件
     */
    public synchronized void set() {
        while (this.storage.size() == this.maxSize) {   // 如果集合已经满了，就等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.storage.add(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notify();       // 唤醒其它线程
    }

    /**
     * 同步方法，使用处理事件集合中的一个事件
     */
    public synchronized void get() {
        while (this.storage.size() == 0) { // 如果集合为空就等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>) storage).poll()); // 消费一个事件
        notify(); // 唤醒其它线程
    }

}
