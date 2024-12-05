package ExceptionHandling;

public class NestedTry {

	public static void main(String[] args) {
		try {
			try {
				int a = 10/0;
			}
			catch(ArithmeticException e) {
				System.out.println("Catched Arithmatic exception");
			}
			
			try {
				int a[] = new int[5];
				a[5]=10;
			}
			catch(ArrayIndexOutOfBoundsException  e) {
				System.out.println("Catched array out of bound exception");
			}
			System.out.println("Inside main try block");
		}
		catch(Exception e) {
			System.out.println("inside main catch block");
		}
		System.out.println("last print statement");
	}
}
