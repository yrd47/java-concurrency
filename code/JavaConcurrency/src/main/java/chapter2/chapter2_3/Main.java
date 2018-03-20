package chapter2.chapter2_3;

/**
 * Created by yrd on 2018/3/9.
 */
public class Main {

    /**
     * 用synchronized关键字保护代码块时，我们使用对象作为它的传入参数。JVM保证同一时间只有一个线程能够访问这个对象的代码保护块（注意我们一直谈论的是对象不是类)
     *
     * @param args
     */
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Thread thread1 = new Thread(new TicketOffice1(cinema), "TicketOffice1");
        Thread thread2 = new Thread(new TicketOffice2(cinema), "TicketOffice2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }
}
