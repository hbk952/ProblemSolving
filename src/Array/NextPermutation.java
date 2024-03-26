package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import String.StringPermutation;

//Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers.
//If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order.
//arr = {1, 2, 3, 6, 5, 4} - o/p : {1, 2, 4, 3, 5, 6}
//arr = {3, 2, 1} - o/p : {1, 2, 3}
//logic - as we have to find a number greater than the given:
// 1. check if the number is sorted is in descending order - if so then reverse the array will be the solution.
// 2. check if the number is sorted in ascending number- if so then swap last element with 2nd last element.
//take two pointers - one from left and another from right - 
public class NextPermutation {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 6, 5, 4};
		//int arr[] = {6,5,1,4,3,2};
		List<Integer> al = nextPermutation(arr.length,arr);
		System.out.println(al);
	}
	
	public static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> ans=new ArrayList<>();
        int ind=-1;
        for(int i=N-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                ind=i;
                break;
            }
        }
        System.out.println("ind value: "+ind);
        if(ind==-1)//array is sorted in descending order - next number is the reverse
        {
            for(int i=0;i<N;i++)
            {
                ans.add(arr[i]);
            }
            
            Collections.reverse(ans);
            return ans;
        }
        //if array is not sorted in descending order
        int temp=0;
        for(int i=N-1;i>ind;i--) //run a loop from last till the inversion index found
        {
            if(arr[i]>arr[ind])//if a number from last is greater than the number at inversion index - do swap.
            {
                temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                break;
            }
        }
        System.out.println("Array after swap: ");
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) 
        {
            ans.add(arr[i]);
        }
        List<Integer> ans1=ans.subList(ind+1,N);
        System.out.println("ans1: "+ans1);
        Collections.reverse(ans1);
        System.out.println("ans1 after reversing: "+ans1);
        
        return  ans;
    }

}
