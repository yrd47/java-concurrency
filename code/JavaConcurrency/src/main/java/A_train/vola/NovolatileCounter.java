package A_train.vola;

public class NovolatileCounter {
	
	public static int count = 0;
	public static volatile int c = 0;
	
	public static void increase() {
		try {  
            Thread.sleep(1);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        count++; 
        c++;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					NovolatileCounter.increase();
				}
			}).start();
		}
		
		System.out.println("Result: NovolatileCounter.count = " + NovolatileCounter.count);
		//加了volatile依然不是1000
		System.out.println("Result: NovolatileCounter.count = " + NovolatileCounter.c);
	}

}
