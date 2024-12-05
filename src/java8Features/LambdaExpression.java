package java8Features;

interface addNumbers{ //functional interface - only one abstract method
	int addTwoNumbers(int a, int b);
}
public class LambdaExpression {

	public static void main(String[] args) {
		addNumbers an = (int a, int b)->{  return (a+b); };
		System.out.println(an.addTwoNumbers(5, 4));

	}

}
