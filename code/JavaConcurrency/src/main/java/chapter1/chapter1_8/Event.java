package chapter1.chapter1_8;

import java.util.Date;

/**
 * 事件类，存储时间信息
 * Created by yrd on 2018/3/6.
 */
public class Event {

    private Date date;
    private String  event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
