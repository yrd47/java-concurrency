package chapter3.chapter3_4;

import java.util.concurrent.TimeUnit;

/**
 *
 *
 * Created by yrd on 2018/3/20.
 */
public class Participant implements Runnable {

    /**
     * 视频会议对象
     */
    private VideoConference conference;
    /**
     * 参与者的名称（仅仅是为了记录使用）
     */
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    /**
     * 核心方法，等待一个随机时间就进入视频会议
     */
    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
