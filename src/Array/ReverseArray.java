package Array;

public class ReverseArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,6,2,9,3};
		int c[] = reverseArray(a);
		for(int k : c) {
			System.out.println(k);
		}

	}
	public static int[] reverseArray(int a[]) {

		for(int i=0;i<a.length/2;i++) {
			int temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i]=temp;
			
		}
		return a;
	}

}
