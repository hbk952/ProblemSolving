package oops;

//Parent Class1 
class testA { 
 void fun() { System.out.println("Parent1"); } 
} 

//Parent Class2 
class testB { 
 void fun() { System.out.println("Parent2"); } 
} 

public class DiamondProblem extends testA, testB {

	public static void main(String[] args) {
		DiamondProblem dp = new DiamondProblem();
		dp.fun();

	}

}
