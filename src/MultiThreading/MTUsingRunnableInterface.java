package MultiThreading;

public class MTUsingRunnableInterface {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
	}
}

class MyThread implements Runnable{

	@Override
	public void run() {
		// task which you want your thread to do
		for(int i=0;i<5;i++) {
			System.out.println("Value of i is "+i);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Exception occured");
			}
		}
	}	
}