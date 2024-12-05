package PrototypeDesignPattern;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		NetworkConnection nc1 = new NetworkConnection();
		nc1.setIp("192.2.1.308");
		nc1.loadImportantData();
		System.out.println(nc1);
		
		//cloning nc1
		try {
			NetworkConnection nc2 = (NetworkConnection)nc1.clone();
			System.out.println(nc2);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
