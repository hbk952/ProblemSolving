package Array;

public class AddTwoArrays {

	public static void main(String[] args) {
		int a[] = {1,2,3};
		int b[] = {9,9};	//expected output = 222
		int c[] = new int[a.length+b.length];
		int i = a.length-1;
		int j = b.length-1;
		int k = c.length-1;
		int leftRemainder = 0;
		int sum = 0;
		while(i>=0 && j>=0) {
			sum = a[i]+b[j]+leftRemainder;
			c[k] = (sum)%10;
			leftRemainder = (sum)/10;
			System.out.println(sum+" "+leftRemainder);
			k--;
			i--;
			j--;
		}
		
		while(i>=0) {
			c[k] = (a[i]+leftRemainder)%10;
			leftRemainder = (a[i]+leftRemainder)/10;
			k--;
			i--;
		}
		
		while(j>=0) {
			c[k] = (b[j]+leftRemainder)%10;
			leftRemainder = (b[j]+leftRemainder)/10;
			k--;
			j--;
		}
		
		for(int m : c) {
			System.out.println(m);
		}

	}

}
