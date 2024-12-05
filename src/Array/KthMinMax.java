package Array;
//sorting till kth element
public class KthMinMax {

	public static void main(String[] args) {
		int a[] = {1,2,3,6,0,2,9,3}; //01223369
		int k = 2;
		if(k<a.length) {
			kthMinimum(a,k);
			kthMaximum(a,k);
		}
		else {
			System.out.println("K should be less than last index of array");
		}
	}
	
	public static void kthMinimum(int []a, int k) {	//insertion sort till kth index
		for(int i=0;i<k;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Kth Minimum: "+a[k-1]);
	}
	
	public static void kthMaximum(int []a, int k) {
		for(int i=a.length-1;i>=a.length-k;i--) {
			for(int j=0;j<i;j++) {
				if(a[i]<a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Kth Max: "+a[a.length-k]);
	}

}
