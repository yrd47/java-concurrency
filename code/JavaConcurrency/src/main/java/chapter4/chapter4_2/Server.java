package chapter4.chapter4_2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 服务类，模拟一个服务器
 *
 * Created by yrd on 2018/3/23.
 */
public class Server {

    /**
     * 线程池执行器，管理请求线程的执行
     */
    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();    // 本质是一个缓冲线程池对象
    }

    /**
     * 任务执行方法 接收Task对象作为参数并将其提交到执行者
     *
     * @param task Task对象
     */
    public void executeTask(Task task){
        // 首先，写入一条信息到控制台，表明有一个新的任务到达。
        System.out.printf("Server: A new task has arrived\n");
        //然后，调用执行者的execute(）方法来提交这个任务
        executor.execute(task);
        //最后，将执行者的数据写入到控制台来看它们的状态
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    /**
     * 结束执行的方法
     */
    public void endServer() {
        executor.shutdown();
    }

}
