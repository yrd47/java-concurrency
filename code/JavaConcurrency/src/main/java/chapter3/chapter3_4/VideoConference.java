package chapter3.chapter3_4;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yrd on 2018/3/20.
 */
public class VideoConference implements Runnable {

    /**
     * 倒计时闩对象
     */
    private final CountDownLatch countDownLatch;

    /**
     * 构造函数，初始化倒计时闩
     * @param number 参与者人数
     */
    public VideoConference(int number) {
        countDownLatch = new CountDownLatch(number);
    }

    /**
     * 每个参与到视频会议的都会调用此方法
     * @param name 参与者
     */
    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        countDownLatch.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", countDownLatch.getCount());
    }

    /**
     * 核心方法，当所有参与者都到达了，就开始视频会议
     */
    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", countDownLatch.getCount());
        try {
            // Wait for all the participants
            countDownLatch.await();

            // Starts the conference
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
