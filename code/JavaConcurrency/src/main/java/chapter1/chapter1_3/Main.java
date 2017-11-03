package chapter1.chapter1_3;

import chapter1.chapter1_2.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yrd on 2017/11/3.
 */
public class Main {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread" + i);
        }
        try (FileWriter fileWriter = new FileWriter("./result.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (int i = 0; i < 10; i++) {
                printWriter.println("Main : Status of Thread " + threads[i].getId() + " : " + threads[i].getState());
                states[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) {
                        writeThreadInfo(printWriter, threads[i], states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter printWriter, Thread thread, Thread.State state) {
        printWriter.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        printWriter.printf("Main : Priority : %d\n", thread.getPriority());
        printWriter.printf("Main : Old State : %s\n", state);
        printWriter.printf("Main : New State : %s\n", thread.getState());
        printWriter.printf("Main : *************************\n");
    }
}
