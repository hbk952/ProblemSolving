package BinarySearch;
//first use case of binary search
// Modified Binary search at the base case that is a[mid] == key.
//Earlier we are returning from here in normal Binary search. But Now for :
//first occurence : store the answer and do last = mid-1
//last occurence : store the answer and do start = mid+1

public class FirstAndLastOccurence {

	public static void main(String[] args) {
		int a[] = {10,20,40,60,80,80,80,80,90};
		int key =80;
		int first_index = firstOccurence(a,key);
		int last_index = lastOccurence(a,key);
		System.out.println("First occurence of "+key+" is : "+first_index+" And last occurence is : "+last_index);
		int total_occurence = last_index - first_index + 1;
		System.out.println("Total occurence : "+ total_occurence);
	}
	public static int firstOccurence(int a[],int key) {
		int start = 0;
		int last = a.length-1;
		int ans = -1;
		int mid = start+(last-start)/2;
		
		while(start<=last) {
			if(a[mid] ==key) {	
				 ans = mid;		//only change when compared with binary search
				 last = mid-1;
			}
			else if(a[mid] > key ) {
				last= mid-1;
			}
			else {
				start = mid+1;
			}
			mid = start+(last-start)/2;
		}
		return ans;
	}
	
	public static int lastOccurence(int a[],int key) {
		int start = 0;
		int last = a.length-1;
		int ans = -1;
		int mid = start+(last-start)/2;
		
		while(start<=last) {	//only change when compared with binary search
			if(a[mid] ==key) {
				 ans = mid;
				 start = mid+1;
			}
			else if(a[mid] > key ) {
				last= mid-1;
			}
			else {
				start = mid+1;
			}
			mid = start+(last-start)/2;
		}
		return ans;

	}

}
