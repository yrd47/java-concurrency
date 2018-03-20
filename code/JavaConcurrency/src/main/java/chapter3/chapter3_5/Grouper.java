package chapter3.chapter3_5;

/**
 * 组合类，汇总查找的结果
 *
 * Created by yrd on 2018/3/20.
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    /**
     * 核心方法，对查找的结果进行汇总
     */
    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int[] data = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
