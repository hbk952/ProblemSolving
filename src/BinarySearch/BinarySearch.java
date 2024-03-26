package BinarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = {10,20,40,60,70,80,90};
		int key =80;
		//boolean result = binarySearch(a,key);
		boolean result = binarySearchRecursion(a,0,a.length-1,key);
		if(result) {
			System.out.println("found");
		}
		else {
			System.out.println("Not found");
		}
	}
	public static boolean binarySearch(int a[],int key) {
		int start = 0;
		int last = a.length-1;
		int mid = start+(last-start)/2;
		
		while(start<=last) {
			System.out.println(start+" "+mid+" "+last);
			if(a[mid] ==key || a[start] == key || a[last] == key) {
				return true;
			}
			else if(a[mid] > key ) {
				last= mid-1;
			}
			else {
				start = mid+1;
			}
			mid = start+(last-start)/2;
		}
		return false;

	}
	
	public static boolean binarySearchRecursion(int a[],int start, int last,int key) {
		if(start>=last) {
			return false;
		}
		int mid = start+(last-start)/2;
		if(a[mid] == key) {
			return true;
		}
		
		else if(a[mid] < key) {
			return binarySearchRecursion(a,mid+1,last,key);
		}
		else {
			return binarySearchRecursion(a,start,mid-1,key);
		}
		
	
	}

}
