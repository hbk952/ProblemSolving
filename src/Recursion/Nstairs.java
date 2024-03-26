package Recursion;
//Find how many to n climb stairs if one can climb 1 or 2 stairs at a time.
public class Nstairs {

	public static void main(String[] args) {
		int stairs=5;
		int ways = nWaysToClimbStairs(stairs);
		System.out.println("Ways to climb: "+ways);

	}
	public static int nWaysToClimbStairs(int n) {
		if(n<0) { 	//if the person is in basement - not started to climb
			return 0;
		}
		if(n==0) {	// if the person at 0th step - climb to 1st - return to 0th - 1 way.
			return 1;
		}
		int ways = nWaysToClimbStairs(n-1)+ nWaysToClimbStairs(n-2);
		return ways;
	}

}
