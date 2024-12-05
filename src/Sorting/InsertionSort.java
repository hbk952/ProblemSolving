package Sorting;
//In Bubble sort, we compare jth element with j+1th. While in Insertion sort we compare ith element with the jth one.
//Average and worst time complexity = n^2
public class InsertionSort {

	public static void main(String[] args) {
		int a[] = {4,1,7,3,9,3,2,6,7};
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for(int k : a) {
			System.out.print(k+" ");
		}


	}

}
