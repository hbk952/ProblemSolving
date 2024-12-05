package Array;
//Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.
//Ex: A[] = {1, 4, 45, 6, 0, 19} and x  =  51 - solution: {4, 45, 6}
//add the array elements till sum>x. Then take start and end index of the subarray you got.
//Now try to remove the element from subarray from start index till sum>x and accordingly set the start index.
//finally you will get the subarray with start and index subarray.
public class SubArrayWithSumGreaterThanX {

	public static void main(String[] args) {
		//int a[] = {1, 4, 45, 6, 0, 19};
		//int x = 51;
		int a[]={1, 10, 5, 2, 7};
		int x = 9;
		int sum = 0;
		int start_idx=0;
		int end_idx=0;
		//add the array elements till sum>x
		for(int i=0;i<a.length;i++) {
			if(a[i]+sum>sum) {
				sum=sum+a[i];
				if(sum>x) {
					end_idx = i;
					break;
				}
			}
			else {
				sum=0;
				//reinitialise the subarray indexes
				start_idx = i+1;
				end_idx = i+1;
			}
		}
//		System.out.println(start_idx+" "+end_idx);
//		System.out.println(sum);
		
		//Now try to remove the element from subarray from start index till sum>x
		for(int j=start_idx;j<=end_idx;j++) {
			if(sum-a[j]>x) {
				sum = sum-a[j];
				start_idx = j+1;
			}
		}
		
//		System.out.println(start_idx+" "+end_idx);
//		System.out.println(sum);
		
		for(int k=start_idx;k<=end_idx;k++) {
			System.out.print(a[k]+" ");
		}

	}

}
