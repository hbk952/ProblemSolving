package BinarySearch;
//same logic will be for painter partition
//Given an array of n length where n = no. of books and n[i] = no. of pages in ith book. m = no. of students to be allocated book such  that maximum number of pages allocated to a student is minimum.
//Use Binary search  - assume an array from range 0 to sum of array. 
//Go to mid ,let say =50.Now starting iterating array from i=0 till sum[i]<mid. If sum[i]> mid - allocate now to different students from ith element till sum<mid. Run for loop till m students gets books.

public class BookAllocation {

	public static void main(String[] args) {
		int arr[]= {10,20,30,40};
		int m=2;
		int sum = sumOfArray(arr);
		int result = bookAllocation(arr,sum,m);
		System.out.println(result);

	}
	
	public static int sumOfArray(int arr[]) {
		int result = 0;
		for(int i : arr) {
			result = result+i;
		}
		return result;
	}
    public static int bookAllocation(int arr[],int sum,int m) {
		//assuming a array search space from 0 to sum of array - apply binary search.
    	int s = 0;
    	int e = sum;
    	int ans = 0;
    	int mid = s+(e-s)/2;
    	while(s<=e) {
    		if(isPossibleSolution(arr,mid,m)) { //if mid is a possible solution then all numbers>mid is also a possible solution. But we have find minimum so store the result and do e = mid-1.
    			ans = mid;
    			e = mid-1;
    		}
    		else {//if mid is not a possible solution then go for higher mid value via s = mid+1;
    			s = mid+1;
    		}
    		mid = s+(e-s)/2;
    	}
    	return ans;
	}
    public static boolean isPossibleSolution(int arr[],int mid,int m) { //if all students gets book then it is a possible solution
    	int sum = 0;
    	int studentCount=1;
    	for(int i=0;i<arr.length;i++) {
    		if(sum+arr[i]<=mid) {
    			sum = sum+arr[i];
    		}
    		else {
    			studentCount++; //if sum > mid then start allocation for new student.
    			if(studentCount>m || arr[i]>mid) {
    				return false;
    			}
    			sum = arr[i]; //reinitialise the sum for new student
    		}
    	}
    	return true;
    }

}
