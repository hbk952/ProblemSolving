package BinarySearch;
//second use case of binary search
//When we traverse from index 0 to index arr.length-1, elements will be in increasing order till peak and then decreases.
//we will use binary search such as : if arr[i]<arr[i+1] or arr[mid]<arr[mid+1] we are in the left part of the peak thus go closer to the peak by start = mid+1
//else we are in right or at the peak thus end = mid;
//			60
//		50
//	40			40
//					10
//if we have multiple peak then this may not work then we have to go via linear search finding the largest number.
public class PeakInMountainArray {

	public static void main(String[] args) {
		int a[] = {40,50,60,40,10};
		int s = 0;
		int e = a.length-1;
		int mid = s+(e-s)/2;
		while(s<e) {	//in binary search it is s<=e
			if(a[mid]<a[mid+1]) {	//if we are on left part of the peak
				s= mid+1;
			}
			else {	//we are on peak of right to the peak
				e =mid;
			}
			mid = s+(e-s)/2;
		}
		System.out.println("peak element index: "+s+" with value: "+a[s]);

	}

}
