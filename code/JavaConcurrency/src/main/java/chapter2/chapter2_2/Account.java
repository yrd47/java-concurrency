package chapter2.chapter2_2;

/**
 * 账户类，模拟有个银行账户
 *
 * Created by yrd on 2017/11/24.
 */
public class Account {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 增加帐户余额
     *
     * @param amount 增加的余额
     */
    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    /**
     * 减少帐户余额
     *
     * @param amount 减少的余额
     */
    public synchronized  void subtractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }
}
