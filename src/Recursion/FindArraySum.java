package Recursion;

public class FindArraySum {

	public static void main(String[] args) {
		int a[] = {3,2,5,1,2};
		int sum = 0;
		sum = findSum(a,a.length-1);
		System.out.println(sum);

	}
	public static int findSum(int a[], int len) {
		if(len<0) {
			return 0;
		}
		
		return a[len]+findSum(a,len-1);
	}
}
