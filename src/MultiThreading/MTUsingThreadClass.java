package MultiThreading;

public class MTUsingThreadClass {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		Thread t = new Thread(mt1);
		t.start();
		
		MyThread2 mt = new MyThread2();
		mt.start();
		
	}

}

class MyThread2 extends Thread{

	@Override
	public void run() {
		// task which you want your thread to do
		for(int i=5;i>=0;i--) {
			System.out.println("Value of another thread i is "+i);
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println("Exception occured");
			}
		}
	}	
}