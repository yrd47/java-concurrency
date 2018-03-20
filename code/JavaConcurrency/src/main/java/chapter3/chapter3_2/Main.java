package chapter3.chapter3_2;

/**
 * 资源的并发访问控制
 * Semaphore    信号量是一种计数器，用来保护一个或者多个共享资源的访问
 * 如果线程要访问一个共享资源，它必须先获得信号量。如果信号量的内部计数器大于0 ,信号量将减1 ,然后允许访问这个共享资源。计数器大于0意味着有可以使用的资源, 因此线程将被允许使用其中一个资源
 * 否则，如果信号量的计数器等于0 ,信号量将会把线程置入休眠直至计数器大于0。计数器等于0的时候意味着所有的共享资源已经被其他线程使用了，所以需要访问这个共享资源的线程必须等待
 *
 * Created by yrd on 2018/3/20.
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
            threads[i].start();
        }
    }
}
