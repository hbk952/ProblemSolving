package Array;
//Kadane Algo - //Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
public class SubArrayWithMaxSum {

	public static void main(String[] args) {
		int a[] = {-1,2,3,-2,5};
		long curr = 0;
        long maxarr = -1;
        for(int i=0; i<a.length; i++){
            curr += a[i];
            if(curr > maxarr){
                maxarr = curr;
            }
            if(curr < 0){
                curr =0;
            }
        }
        System.out.println(maxarr);
	}

}
