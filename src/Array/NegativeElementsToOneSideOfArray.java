package Array;

public class NegativeElementsToOneSideOfArray {

	public static void main(String[] args) {
		int a[]= {-1,-2,8,-1,5,-3,4};
		
		int positive=0;
		boolean findPositive=false;
		for(int k=0; k<a.length; k++) {
			
			if(a[k]>=0 && findPositive==false) {
				positive=k;
				findPositive = true;
			}
			else if(a[k]<0 && findPositive==true) {
				int temp = a[k];
				a[k] = a[positive];
				a[positive]=temp;
				//Either ways are giving the same results
					//findPositive=false;
					//k=positive;
				positive++;
				
				
			}
			
		}
		for(int i : a) {
			System.out.print(i+" ");
		}

	}

}
