package AdaptorDesignPattern;

public class Adaptor implements AppleCharger{
	
	private AndroidCharger charger;

	public Adaptor(AndroidCharger charger) {
		this.charger = charger;
	}

	@Override
	public void chargeIphone() { //overriding the implementation of apple charger to use android charger with adaptor
		charger.chargeAndroidPhone();
		System.out.println("Your phone is charging with adaptor");
	}

}
