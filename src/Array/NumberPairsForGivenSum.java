package Array;

import java.util.HashMap;
import java.util.Map;

//Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
//K = 6 and arr[] = {1, 5, 7, 1} - output=2 - arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
public class NumberPairsForGivenSum {

	public static void main(String[] args) {
		int k=6;
		int arr[] = {1, 5, 7, 1};
		int pairs = countPairs(arr,k);
		System.out.println(pairs);
	}
	public static int countPairs(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(k-arr[i])){
                count += map.get(k-arr[i]); //count increased by the number = no. of occurence of such element which is stored as value in Map. 
            }
            if(k-arr[i]==arr[i]){ //if diff is same as the element, decrease count by 1 to not count itself.
                count--;
            }
        }
        return count/2; //divided by 2 so that neglect the repititive count.
        
        
    }

}
