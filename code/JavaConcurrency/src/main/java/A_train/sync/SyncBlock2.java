package A_train.sync;

/**
 * 指定给某个对象加锁
 * @author yrd
 *
 */

class Account {
	String name;
	float amount;
	
	public Account(String name, float amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public void deposit(float amt) {
		amount += amt;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void withDraw(float amt) {
		amount -= amt;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public float getBalance() {
		return amount;
	}
}

/**
 * 账户操作类
 * @author yrd
 *
 */
class AccountOperator implements Runnable {
	private Account account;
	
	public AccountOperator(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		synchronized (account) {
			account.deposit(500);
			account.withDraw(500);
			System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
		}
	}
}

public class SyncBlock2 {

	public static void main(String[] args) {
		Account account = new Account("y", 100000f);
		AccountOperator accountOperator = new AccountOperator(account);
		
		final int THREAD_NUM = 5;
		Thread[] threads = new Thread[THREAD_NUM];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(accountOperator, "Thread" + i);
			threads[i].start();
		}
	}
	
}
