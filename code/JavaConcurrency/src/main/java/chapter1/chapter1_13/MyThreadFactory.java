package chapter1.chapter1_13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by yrd on 2018/3/7.
 */
public class MyThreadFactory implements ThreadFactory {


    private int counter;            // 线程计数器，计数已经产生了多少个线程
    private String name;            // 线程的基准名称
    private List<String> stats;     // 线程统计信息集合

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    /**
     * 使用Runnable对象创建一个线程
     *
     * @param r Runnable对象
     * @return 线程对象
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    /**
     * 获取线程工厂的统计信息
     *
     * @return 线程工厂的统计信息
     */
    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
