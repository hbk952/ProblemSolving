package oops;

public interface CheckInterface {
	int number=10; //variables need to be initialised
	static int staticNumber = 20;
	final String name="Harish"; 
	
	//Interface methods are by default abstract and public
	void display();// when you try to define it by providing body - throw compilation error.
	public void publicDisplay();
	
	default void defaultDisplay() { //not allowed in abstract in java 8
		System.out.println("this s");
	}
	static void staticDisplay() {
		System.out.println("inside static method");
	}
	
	
}
