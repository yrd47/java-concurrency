package chapter1.chapter1_2;

/**
 * Created by yrd on 2017/11/3.
 */
public class CalculatorThread extends Thread {

    private int number;
    public CalculatorThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = number; i <= 10; i++) {
            System.out.printf("%s : %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }
}
