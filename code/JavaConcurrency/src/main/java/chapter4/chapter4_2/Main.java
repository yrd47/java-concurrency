package chapter4.chapter4_2;

/**
 * 创建线程执行器
 *
 * 使用执行器框架（Executor Framework)的第一步是创建ThreadPoolExecutor对象。
 * 可以ThreadPoolExecutor类提供的四个构造器或者使用Executors工厂类来创建 ThreadPoolExecutor对象。一旦有了执行器，就可以将Runnable或Callable对象发送给它去执行了
 *
 * Created by yrd on 2018/3/23.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();
    }
}
