package Array;
import java.util.Arrays;
//Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
//There are M students, the task is to distribute chocolate packets among M students such that - 
//Each student gets exactly one packet and The difference between maximum and minimum number of chocolates given to a student is minimum.
//Ex: A = {3, 4, 1, 9, 56, 7, 9, 12} and M = 5 then solution is {3, 4, 9, 7, 9} with minimum diff = 6.
//Solution : Sort the array and consider a window of M length. check the difference between i and M index array - minimum is the solution.

public class ChocolateDistribution {

	public static void main(String[] args) {
		int a[] = {3, 4, 1, 9, 56, 7, 9, 12};
		int M = 5;
		int diff = Integer.MAX_VALUE;
		int extremeIdx = M-1; //initialising the extreme index of subarray of solution.
		Arrays.sort(a);
		for(int i=0; i<=a.length-M;i++) {
			if(a[i+M-1]-a[i]<diff) {
				diff = a[i+M-1]-a[i];
				extremeIdx = i+M-1;
			}
		}
		System.out.println(diff);
		for(int j = extremeIdx-M+1;j<=extremeIdx;j++) {
			System.out.print(a[j]+" ");
		}
		

	}

}
