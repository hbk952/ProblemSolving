package oops;

public class FinalizeMethod {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.m1();
		demo=null; //object de-refernced forcefully
		System.gc(); //call finalize method
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize method called");
	}
}

class Demo{

	public void m1() {
		System.out.println("m1 method");
		
	}
}
