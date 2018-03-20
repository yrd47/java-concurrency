package chapter2.chapter2_4;

/**
 * Created by yrd on 2018/3/20.
 */
public class Consumer implements Runnable {

    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            this.eventStorage.get(); // 消费事件
        }
    }
}
