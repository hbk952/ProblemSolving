package AdaptorDesignPattern;

public class MyIphone {
	private AppleCharger appleCharger;
	//constructor injection
	public MyIphone(AppleCharger appleCharger) {
		this.appleCharger = appleCharger;
	}
	
	public void chargeMyIphone() {
		appleCharger.chargeIphone();
	}
	

}
