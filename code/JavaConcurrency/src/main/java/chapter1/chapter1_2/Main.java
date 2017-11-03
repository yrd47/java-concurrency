package chapter1.chapter1_2;

/**
 * Created by yrd on 2017/11/3.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Calculator calculator= new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
            Thread.sleep(100);
        }

        Thread.sleep(2000);

        System.out.println("-----------");
        for (int i = 1; i <= 10; i++) {
            CalculatorThread calculatorThread = new CalculatorThread(i);
            calculatorThread.start();
            Thread.sleep(100);
        }
    }
}
