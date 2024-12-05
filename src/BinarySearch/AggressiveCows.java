package BinarySearch;

import java.util.Arrays;

//given an array of length N where N denotes the number of cow stalls and elements in the array denotes the position of the stalls.
//given k is the number of cows. FInd the largest minimum possible distance between the two cows so that two cannot hurt each other
//Let say array {4,1,2,3,6}.Search space will be 0 to (max element-min element). Let say 4 is not a possible solution - will ignore left or right part in the search space to look for a solution - conditions to use the binary search.

public class AggressiveCows {

	public static void main(String[] args) {
		int arr[]= {4,1,2,3,6};
		int k=2;
		Arrays.sort(arr);
		//search space will be 0 to (max element-min element)
		int result = stallAllocation(arr,k);
		System.out.println(result);
	}
	
	public static int stallAllocation(int arr[],int k) {
		int s = 0;
    	int e = arr[arr.length-1]-arr[0];
    	int ans = 0;
    	int mid = s+(e-s)/2;
    	while(s<=e) {
    		if(isPossibleSolution(arr,mid,k)) { //if mid is a possible solution then all numbers>mid is also a possible solution. We have to find largest possible distance, so store the result and do s=mid+1.
    			ans = mid;
    			s=mid+1;
    		}
    		else {//if not a possible solution then go for lower value via e=mid-1;
    			e=mid-1;
    		}
    		mid = s+(e-s)/2;
    	}
    	return ans;
	}
	public static boolean isPossibleSolution(int stalls[],int mid,int k) { 
    	int cowCount=1;
    	int lastPos = 0;
    	for(int i=1;i<stalls.length;i++) {
    		if(stalls[i]-stalls[lastPos]>=mid) {
    			cowCount++; 
    			if(cowCount==k ) {
    				return true;
    			}
    			lastPos = i;
    		}
    	}
    	return false;
    }

	
}
