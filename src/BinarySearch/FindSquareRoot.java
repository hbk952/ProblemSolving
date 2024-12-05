package BinarySearch;

public class FindSquareRoot {

	public static void main(String[] args) {
		int num = 38;	//we will assume array from value 0 to num
		int tempIntSoln = sqrtInteger(num);
		System.out.println("Nearest integer to squareroot: "+tempIntSoln);
		double finalAns = precisionResult(tempIntSoln,2,num);
		System.out.println("Square root of "+num+" : "+finalAns);
	}
	public static int sqrtInteger(int num) {
		int s = 0;
		int e = num;
		int mid = s+(e-s)/2;
		int ans = -1;
		while(s<=e) {
			System.out.println(mid);
			long square = mid*mid;
			System.out.println(square);
			if( square== num) {
				ans = mid;
				return ans;
			}
			if(square<num) {
				ans = mid;
				s = mid+1;
				
			}
			else {
				e = mid-1;
			}
			mid = s+(e-s)/2;
		}
		return ans;
	}
	
	public static double precisionResult(int tempSol,int precision,int num) {
		double factor = 1;
		double ans = tempSol;
		for(int i=0;i<precision;i++) {
			factor = factor/10;
			double j = ans;
			while(j*j<num) {
				ans = j;
				j = j+factor;
			}
			
		}
		return ans;
	}

}
