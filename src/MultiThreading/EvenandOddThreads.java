package MultiThreading;

public class EvenandOddThreads {
	volatile static int counter = 1;
	int limit;
	
	public EvenandOddThreads(int limit) {
		super();
		this.limit = limit;
	}

	public synchronized void printOdd() {
		while(counter<=limit) {
			if(counter%2==1) {
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				notifyAll();
			}
			else {
				try {
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void printEven() {
		while(counter<=limit) {
			if(counter%2==0) {
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				notifyAll();
			}
			else {
				try {
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		EvenandOddThreads print = new EvenandOddThreads(10);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				print.printOdd();
			}
		});
		t1.setName("odd");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				print.printEven();
			}
		});
		t2.setName("even");
		t1.start();
		t2.start();
	}

}
