package ExceptionHandling;

import java.io.IOException;

public class OverridingException extends Parent{
	@Override
	void msg() throws ArithmeticException {  //ArithmeticException - subclass for parent method exception  
		System.out.println("TestExceptionChild");    
	}  
	public static void main(String[] args) {
		 Parent p = new OverridingException(); 
		 try {
			 p.msg();
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}

}
class Parent{    
	  void msg() throws Exception {  
	    System.out.println("parent method");  
	    }    
}    