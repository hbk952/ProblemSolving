package Sorting;
//In Bubble sort, we compare jth element with j+1th. While in Insertion sort we compare ith element with the jth one.
//Average and worst time complexity = n^2
public class BubbleSort {

	public static void main(String[] args) {
		int a[] = {4,1,7,3,9,3,2,6,7};
		for(int i=0;i<a.length-1;i++) {
			boolean swapped = false;
			for(int j=0;j<a.length-1-i;j++) { // ith element from last gets its place in every iteration of this loop.
				if(a[j]>a[j+1]) {			// such as after 1st iteration , last element got the maximum.After 2nd Iteration,2nd last element got the 2nd highest
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = true;
				}
			}
			if(swapped == false) { //optimisation - if no swap in first run - all are sorted then no need to go for i=1 and further.
				break;
			}
		}
		for(int k : a) {
			System.out.print(k+" ");
		}

	}

}
