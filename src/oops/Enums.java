package oops;

class Enums {
	
	public static void main(String[] args) {
		System.out.println(Mobile.APPLE.getPrice());
	}
}

enum Mobile{
	APPLE, SAMSUNG, HTC;
	
	int price;
	Mobile(){
		price= 80;
	}
	public int getPrice() {
		return price;
	}
}

//understood ENUM imlementation as - 
class Mobile{
	static final Mobile APPLE = new Mobile();
	int price=80;
	Mobile(){
		price = 80;
	}
	public int getPrice() {
		return price;
	}
}


class StaticBlocks{
	static {
		System.out.println("static");
	}
	static {
		System.out.println("block");
	}
	StaticBlocks(){
		System.out.println("this is constructor");
	}
	
	public static void main(String[] args) {
		StaticBlocks sb = new StaticBlocks();
	}
}





