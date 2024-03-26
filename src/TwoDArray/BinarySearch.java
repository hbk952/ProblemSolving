package TwoDArray;
//Considering a binary array of m*n.
public class BinarySearch {

	public static void main(String[] args) {
		int a[][] = {{1,3,5,7},
				{10,11,16,20},
				{23,30,34,60}
				};	//in linear array  - 1,3,5,7,10,11,16,20,23,30,34,60
		int key = 6;
		int row = a.length;
		int col = a[0].length;
		int start = 0;
		int end = row*col-1;
		int mid = start+(end-start)/2; //for 1st iteration, mid = 5 - element at mid = 11 = i,j = 1,1
		while(start<=end) {
			int midelement = a[mid/col][mid%col];	//ith index for mid = 5/4 = 1 and jth index for mid = 5%4 = 1
			if(midelement == key) {
				System.out.println("found");
				break;
			}
			else if(midelement > key ) {
				end= mid-1;
			}
			else {
				start = mid+1;
			}
			mid = start+(end-start)/2;
		}
		System.out.println("Not found");

	}

}
