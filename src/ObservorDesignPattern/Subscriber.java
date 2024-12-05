package ObservorDesignPattern;

public class Subscriber implements Observer{
	
	String name;
	
	public Subscriber(String name) {
		this.name = name;
	}


	@Override
	public void notified(String title) {
		System.out.println("Hello "+this.name+" one new video uploaded: "+title);
		
	}

}