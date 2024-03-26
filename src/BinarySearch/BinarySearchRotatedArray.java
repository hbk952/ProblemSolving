package BinarySearch;
//third use case of Binary search
//In rotated array , find the array index till which rotation is done.
//If left part from 0 till pivot is increasing and right part of array is from pivot+1 index till last is decreasing then the array is sorted in ascending order.
//		90
//	80
//							70
//						60		
//					40
//				20
//			10
public class BinarySearchRotatedArray {

	public static void main(String[] args) {
		int a[] = {80,90,10,20,40,60,70};
		boolean result;
		int key =40;
		int rotated_index=findPivotLinearSearch(a);	//this is searching the pivot in O(n)
		int index = findPivotBinarySearch(a);	//use the similar binary search method as we have used in PeakIndexMountainArray case. But we will compare a[mid] with a[0] to find pivot because mid+1 is always > mid in both side so we cannot use the comparison of mid and mid+1.
		System.out.println("Pivot with linear search method: "+rotated_index);
		System.out.println("Pivot with binary search: "+index);
		//The array element value is increasing from left to right as the array is sorted in ascending order.
		//If the key> last element and key>=first element of array then the key will be present in left array.Else the present in right part of array.
		if(key>a[a.length-1]) {	//the key present in left part of the pivot
			System.out.println("The key is present left to the rotation index");
			result = binarySearchRecursion(a,0,index-1,key);
		}
		else {	//the key present in right part of the pivot
			System.out.println("The key is present right to the rotation index");
			result = binarySearchRecursion(a,index,a.length-1,key);
		}
		
		if(result) {
			System.out.println("found");
		}
		else {
			System.out.println("Not found");
		}
	}
	
	public static int findPivotLinearSearch(int a[]){
		for(int i=1;i<a.length-1;i++) {
			if(a[i-1]>a[i] && a[i+1]>a[i]) {
				return i;
			}
		}
		return 0;
	}
	public static int findPivotBinarySearch(int []a) {
		int s = 0;
		int e = a.length - 1;
		int mid = s+(e-s)/2;
		while(s<e) {
			//we are considering the minimum value in array or the starting index before rotation as pivot = mid;
			if(a[mid] <a[0]) {	//we are in right part of the pivot. In peak mountain we have used if(a[mid]<a[mid+1]) becoz left and right part are in decreasing from the peak point but here it is increaing to right and decreasing to left from pivot point.
				e=mid;	//going closer to the peak which lies in the left part of mid thus shifting our end index at mid.
			}
			else {	//we are in the left part of the pivot
				s = mid+1;	//going closer to the peak by going to the right part of mid.
			}
			mid = s+(e-s)/2;
		}
		return s;
	}
	public static boolean binarySearchRecursion(int a[],int start, int last,int key) {
		if(start>=last) {
			return false;
		}
		int mid = (start+last)/2;
		if(a[mid] == key || a[start] == key || a[last]==key) {
			return true;
		}
		
		else if(a[mid] < key) {
			return binarySearchRecursion(a,mid+1,last,key);
		}
		else {
			return binarySearchRecursion(a,start,last-1,key);
		}
		
	
	}

}
