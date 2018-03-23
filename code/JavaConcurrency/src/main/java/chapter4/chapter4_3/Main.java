package chapter4.chapter4_3;

import chapter4.chapter4_2.Task;

/**
 * 创建固定大小的线程执行器
 *
 * Created by yrd on 2018/3/23.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();
    }
}
