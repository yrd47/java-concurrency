package chapter1.chapter1_9;

/**
 * Created by yrd on 2018/3/6.
 */
public class Main {

    /**
     * 针对运行时异常，预设置未捕获异常处理器
     * run()方法不支持throw语句
     * @param args
     */
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        //设置线程的异常处理器
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        try {
            thread.join(); // 等待线程完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");
    }
}
