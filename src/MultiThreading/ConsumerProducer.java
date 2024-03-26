package MultiThreading;

public class ConsumerProducer {

	public static void main(String[] args) {
		Company comp = new Company();
		Producer p = new Producer(comp);
		Consumer c = new Consumer(comp);
		p.start();
		c.start();

	}

}

class Company{
	int n;
	boolean f = false; //flag for inter-thread communication
	//if f== false - prodcure will produce and if f== true - consumer chance
	synchronized public void produce_item(int n) { //when producer runs , another thread will not run consumer
		if(f) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.n=n;
		System.out.println("Produced: "+this.n);
		f=true; //after produce , make flag true again to give consumer next chance.
		notify();//notify consumer thread that producer thread done his job
	}
	synchronized public int consume_item() {
		if(!f) { //if f==false - producer producing thus consumer should wait
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("Consumed: "+this.n);
		f=false; //after consume , make flag false again to give producer next chance.
		notify(); //notify producer thread that consumer thread done his job
		return this.n;
	}
}

//for inter-thread communication, create 2 threads - producer and consumer for Company class
class Producer extends Thread{
	Company c;
	Producer(Company c){
		this.c=c;
	}
	
	public void run() {
		int i=1;
		while(true) {
			this.c.produce_item(i);
			i++;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Interuppted exception found");
			}
		}
	}
}


class Consumer extends Thread{
	Company c;
	Consumer(Company c){
		this.c=c;
	}
	
	public void run() {
		while(true) {
			this.c.consume_item();
			
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println("Interuppted exception found");
			}
		}
	}
}
