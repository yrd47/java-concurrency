package chapter1.chapter1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by yrd on 2017/11/23.
 */
public class SafeTask implements Runnable {

    /**
     * 线程局部变量，其中的内容不能共享，线程被初始化时会创建其包含的变量
     * 
     * 匿名内部类 通过这种写法从ThreadLocal继承了一个匿名的子类，在这个子类中覆盖了ThreadLocal的initialValue方法，
     * 同时创建了这个子类的一个实例（因为这个子类是匿名的，无法在后续代码中继续引用，所以必须在定义时同时创建实例）
     */
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread finnish : %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
