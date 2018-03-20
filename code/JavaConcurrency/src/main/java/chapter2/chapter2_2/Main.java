package chapter2.chapter2_2;

/**
 * Created by yrd on 2017/11/27.
 */
public class Main {

    /**
     * synchronized
     *
     * 使用synchronized修饰代码块时必须把对象引用作为传入参数
     *
     * @param args
     */
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial Balance: %f\n", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            //等待两个线程完成
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
