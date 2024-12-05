package AdaptorDesignPattern;

public class ChargeMyPhone {

	public static void main(String[] args) {
		
		AppleCharger charger = new Adaptor(new AndroidChargerCompany());
		MyIphone iphone = new MyIphone(charger);
		iphone.chargeMyIphone();

	}

}
