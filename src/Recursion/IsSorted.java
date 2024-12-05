package Recursion;

public class IsSorted {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		boolean result = checkSorted(a,0);
		if(result) {
			System.out.println("The given array is sorted");
		}
		else {
			System.out.println("The given array is not sorted");
		}

	}
	public static boolean checkSorted(int a[], int startIndex) {
		
		if(startIndex > a.length-2) {
			return true;
		}
		if(a[startIndex]>a[startIndex+1]) {
			
			return false;
		}
		else {
			return checkSorted(a, startIndex+1);
		}
	}

}
