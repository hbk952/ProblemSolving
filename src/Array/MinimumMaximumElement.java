package Array;

public class MinimumMaximumElement {

	public static void main(String[] args) {
		int a[] = {1,2,3,6,0,2,9,3};
		int min =a[0];
		int max = a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
			if(a[i]>max) {
				max =a[i];
			}
		}
		System.out.println("Minimum element in the array: "+min);
		System.out.println("Maximum element in the array: "+max);

	}

}
