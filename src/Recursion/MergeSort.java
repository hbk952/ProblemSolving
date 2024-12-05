package Recursion;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int a[] = {4,9,1,6,3};
		MergeSort ms = new MergeSort();
		ms.sort(a,0,a.length-1);
		for(int i:a) {
			System.out.println(i);
		}

	}
	public void sort(int a[], int s, int e) {
		if(s>=e) {
			return ;
		}
		int mid = s+(e-s)/2;
		//sort left part
		sort(a,s,mid);
		//sort right part
		sort(a,mid+1,e);
		//merge
		merge(a,s,e);
		
	}
	public void merge(int a[],int s, int e) {
		int mid = s+(e-s)/2;
		
		int b[]=Arrays.copyOfRange(a, 0, mid);
		int c[]=Arrays.copyOfRange(a, mid+1, e);
		
		//merging 2 sorted arrays
		int i=0;
		int j=0;
		int k=s;
		while(i<b.length && j<c.length) {
			if(b[i]<c[j]) {
				a[k] = b[i];
				i++;
			}
			else {
				a[k] = c[j];
				j++;
			}
			k++;
		}
		
		while(i<b.length-1) {	//if element of 1st array left
			a[k] = b[i];
			k++;
			i++;
		}
		
		while(j<b.length-1) {	//if element of 2nd array left
			a[k] = c[j];
			k++;
			j++;
		}
			
		
	}

}
