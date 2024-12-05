package Array;
//Rearrange array in alternating positive & negative items with O(1) extra space.
//The element order of appearance has to be maintained(i.e rotate array) and the space complexity limitation is O(1). Thus time complexty O(n^2)
public class AlternatePositiveAndNegative {

	public static void main(String[] args) {
		//int a[] = {1, 2, 3, -4, -1, 4};
		int a[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		mySolution(a);
		System.out.println("\nFinal Array: ");
		for(int i:a) {
			System.out.print(i+" ");
		}
		
	}
	public static void mySolution(int a[]) {
		int neg_ele_count = 0;
		int neg_ele_index= neg_ele_count*2;
		//count of negative element		index to be placed at
		//		1							0
		//		2							2
		//		3							4
		// so we will be increasing the negative element count after placing the element - index will be count*2;
		// for 1st element 0*2; for second element when count is 1, thus index evaluated as 1*2 = 2;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]<0) {
				System.out.println("Negative element found "+a[i] + " at index : "+i);
				
				if(i!=neg_ele_index) { //if negative element is not placed
					if(i< neg_ele_index) { //if negative element lies left to the index to be placed.
						int temp = a[i];
						for(int j = i; j<neg_ele_index; j++) {
							a[j] = a[j+1];	//shift array elements to left from i till negative element index
						}
						a[neg_ele_index] = temp; //place ith element which was at negative element.
						i = neg_ele_index; //so that loop starts after index at which negative element placed.
					}
					else {	//if negative element lies right to the index to be placed.
						int temp = a[i];
						for(int j = i-1; j>=neg_ele_index; j--) {
							a[j+1] = a[j]; //shift array elements to right from 
						}
						a[neg_ele_index] = temp;
						
//						System.out.println("\nArray after operation on Swap array Right: ");
//						for(int j:a) {
//							System.out.print(j+" ");
//						}
					}
				}
				
				neg_ele_count++; //increasing the negative element count
				neg_ele_index = neg_ele_count*2; //next negative element index
				System.out.println("\n negative element count: "+neg_ele_count+ " next negative element index: "+neg_ele_index);
			}
		}
	}
	

}



