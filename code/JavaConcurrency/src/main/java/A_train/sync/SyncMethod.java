package A_train.sync;

/**
 * 
 * @author yrd
 *
 */

class SyncThread1 implements Runnable {
	private static int count;
	
	public SyncThread1() {
		count = 0;
	}

	@Override
	public synchronized void run() {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
		            Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public int getCount() {
		return count;
	}
}

public class SyncMethod {

}
