package ExceptionHandling;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String s) { //checked excpetion - need to be handled using try-catch and throws.
		super(s); //calling constructor of parent i.e Exception
	}
}

class InvalidNameException extends RuntimeException{ //runtime exception - no try-catch and throws required.
	public InvalidNameException(String s) {
		super(s); //calling constructor of parent i.e RuntimeException
	}
}
public class CustomException {
	
	static void validate (int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("Age is below 18");
		}
		else {
			System.out.println("valid age");
		}
	}
	
	static void validateName (String name) { //for unchecked - no throws declaration required
		if(name.startsWith("a")) {
			throw new InvalidNameException("invalid name");
		}
		else {
			System.out.println("valid name");
		}
	}
	public static void main(String[] args) {
		CustomException ce = new CustomException();
		try {
			ce.validate(15); //for checked exception
		}
		catch(InvalidAgeException e){
			System.out.println("Invalid age exception");
		}
		ce.validateName("abc");//for unchecked exception - no try-catch block.
	}
}
