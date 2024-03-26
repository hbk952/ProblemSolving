package oops;

abstract class CheckAbstractClass {
	int number;
	static int staticNumber;
	final String name="Harish"; //here we are not initializing final variable inside constructor.
								//It will be same for all obect.
	CheckAbstractClass(int n, int x){
		this.number=n;
		this.staticNumber=x;
		System.out.println("number: "+number+" ,staticNumber: "+staticNumber+" and name: "+name);
	}
	abstract void display();
	abstract void secondAbstractMethod();
	
	final void finalMethod() {
		System.out.println("this is the final method of abstract class");
	}
	final void finalMethod2() {
		System.out.println("this is the final method of abstract class");
	}
	static void staticMethod() {
		System.out.println("this is the static method of abstract class");
	}
	public void byDefaultMethod() {
		System.out.println("this is the default method of abstract class");
	}
	
}
