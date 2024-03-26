package Recursion;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {6,2,7,3,9};
		QuickSort qs = new QuickSort();
		qs.sort(a,0,a.length-1);
		for(int i:a) {
			System.out.print(i);
		}
	}
	void sort(int a[], int s, int e) {
		if(s>=e) {
			return;
		}
		int p= partition(a,s,e);
		sort(a,s,p-1);
		sort(a,p+1,e);
	}
	int partition(int a[], int s, int e) {
		int pivot = a[s];	//pivot initialization
		int cnt=0;	//counting number of elements valued less than pivat so that we can swap the pivot at the right index
		for(int i=s+1; i<=e; i++) {
			if(a[i]<= pivot) {
				cnt++;
			}
		}
		int pivotIndex = s+cnt;
		//swap to get pivot into right index
		int temp = a[s];
		a[s] = a[pivotIndex];
		a[pivotIndex] = temp;
		
		//use two pointers to take all values < pivot to left side and values > to the right side
		int i =s;
		int j=e;
		while(i<pivotIndex && j>pivotIndex) {
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<pivotIndex && j>pivotIndex) {
				//swap
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			}
		}
		return pivotIndex;
		
	}

}
