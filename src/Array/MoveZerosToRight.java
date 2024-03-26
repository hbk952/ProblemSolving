package Array;

public class MoveZerosToRight {

	public static void main(String[] args) {
		//int arr[] = {2,0,1,3,0,0,0};	//expected output {2,1,3,0,0,0,0}
		int arr[] = {0,1,0,3,12};	//expected output {1,3,12,0,0}
		int zerosIndex = -1;
		boolean zeroFound = false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0 && zeroFound== false) { //no zeros yet we have found
				zerosIndex = i;
				zeroFound = true;
			}
			else if(arr[i] != 0 && zeroFound== true) { //we have found zeros earlier and now we have a non-zero value - swap - now start from the index+1 where non-zero value is swapped 
				int c = arr[i];
				arr[i] = arr[zerosIndex];
				arr[zerosIndex] = c;
				//Either ways are giving the same results
				//zerosIndex++;
				zeroFound=false;
				i=zerosIndex;
			}
		}
		for(int k:arr) {
			System.out.println(k);
		}

	}

}
