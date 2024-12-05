package Array;

public class MergeArrays {

	public static void main(String[] args) {
		int arr1[] = {1,3,5,7,9};
		int arr2[] = {2,4,6};
		int arr3[] = new int[arr1.length + arr2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				arr3[k++] = arr1[i++];
			}
			else {
				arr3[k++] = arr2[j++];
			}
		}
		
		while(i<arr1.length) {	//if element of 1st array left
			arr3[k++] = arr1[i++];
		}
		
		while(j<arr2.length) {	//if element of 2nd array left
			arr3[k++] = arr2[j++];
		}
		
		for(int m: arr3) {
			System.out.print(m);
		}
	}

}


