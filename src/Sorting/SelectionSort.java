package Sorting;
//Selecting a minimum element in first iteration and swapping with first element. Similarly for others
//Average and worst time complexity = n^2
// good for small arrays.
public class SelectionSort {

	public static void main(String[] args) {
		int a[] = {4,1,7,3,9,3,2,6,7};
		for(int i=0;i<a.length-1;i++) { //loop counters are same as the insertion sort
			int min = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			//at the end of iteration we will get the index of element minimum than the element present at ith index
			if(min != i) {
				//Swapping now the ith element with the minimum element
				int temp =  a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			
		}
		for(int k : a) {
			System.out.print(k+" ");
		}

	}

}
