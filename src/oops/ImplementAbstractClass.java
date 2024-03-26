package oops;

public class ImplementAbstractClass extends CheckAbstractClass {
	ImplementAbstractClass(int n, int x) {
		super(n, x);
		// TODO Auto-generated constructor stub
	}
	@Override
	void display() {
		System.out.println("overidden abstract method");
		
	}
	@Override
	void secondAbstractMethod() {
		System.out.println("overriden second abstract method");
		
	}
	void defaultMethod() {
		//super.byDefaultMethod();
		System.out.println("default method overrided during implementing abstract class");
	}
	public static void main(String[] args) {
		ImplementAbstractClass c = new ImplementAbstractClass(1,2);
		c.display();
		c.secondAbstractMethod();
		c.finalMethod();
		c.staticMethod();
		c.defaultMethod();	
	}

}
