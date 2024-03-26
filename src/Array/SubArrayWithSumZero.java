package Array;

import java.util.HashSet;

//Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
//solution - iterate and store sum in hashset/map. Let say sum =4. Iterate the array with summing elements. 
//			If you find the same sum again then there must be an subarray in between which is summing to zero.
public class SubArrayWithSumZero {

	public static void main(String[] args) {
		int nums[] = {4 ,2 ,-3 ,1 ,6};
		HashSet<Integer> h=new HashSet<>();
        
        int sum=0;
        int subArrFoundFlag = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            System.out.println(sum);
            if(h.contains(sum)||sum==0){
                subArrFoundFlag = 1;
                break;
            }
            h.add(sum);

        }
        
        if(subArrFoundFlag == 0) {
        	System.out.println("No");
        }
        else {
        	System.out.println("Yes");
        }
	}

}
