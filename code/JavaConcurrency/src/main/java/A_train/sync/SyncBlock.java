package A_train.sync;

/**
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块
 * @author yrd
 *
 */
class SyncThread implements Runnable {
	private static int count;
	
	public SyncThread() {
		count = 0;
	}

	@Override
	public void run() {
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
		            Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}

public class SyncBlock {
	public static void main(String[] args) {
//		SyncThread syncThread = new SyncThread();
//		Thread thread1 = new Thread(syncThread);
//		Thread thread2 = new Thread(syncThread);
//		thread1.start();
//		thread2.start();
		
		//这两个线程可以同时执行，两把锁分别锁两个SyncThread对象
		Thread thread3 = new Thread(new SyncThread(), "SyncThread1");
		Thread thread4 = new Thread(new SyncThread(), "SyncThread2");
		thread3.start();
		thread4.start();
	}
	
}
