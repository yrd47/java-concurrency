package chapter2.chapter2_3;

/**
 * Created by yrd on 2018/3/9.
 */
public class Cinema {

    private long vacanciesCinema1;
    private long vacanciesCinema2;

    /**
     * 控制vacanciesCinema1同步对象的访问
     */
    private final Object controlCinema1;

    /**
     * 控制vacanciesCinema2同步对象的访问
     */
    private final Object controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();      //  初始化同步控制变量
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;      //设置初始空闲票数
        vacanciesCinema2 = 20;
    }

    /**
     * 出售影院厅1的门票
     * @param number    出售的门票张数
     * @return true出售成功，false出售失败
     */
    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 出售影院厅2的门票
     * @param number    出售的门票张数
     * @return true出售成功，false出售失败
     */
    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 向售影院厅1退门票
     *
     * @param number 退的门票张数
     * @return true退票成功，总返回true
     */
    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    /**
     * 向售影院厅2退门票
     *
     * @param number 退的门票张数
     * @return true退票成功，总返回true
     */
    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    /**
     * 获取影院厅1剩余的门票数
     *
     * @return 影院1剩余的门票数
     */
    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    /**
     * 获取影院厅2剩余的门票数
     *
     * @return 影院2剩余的门票数
     */
    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
