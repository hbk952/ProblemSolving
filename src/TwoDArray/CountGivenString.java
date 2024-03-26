package TwoDArray;
//Count of number of given string in 2D character array
//Traverse matrix character by character and take one character as string start 
//For each character find the string in all the four directions recursively
public class CountGivenString {

	public static void main(String[] args) {
		char a[][] ={
			{'D','D','D','G','D','D'},
			{'B','B','D','E','B','S'},
	        {'B','S','K','E','B','K'},
	        {'D','D','D','D','D','E'},
	        {'D','D','D','D','D','E'},
	        {'D','D','D','D','D','G'}};
	     String str= "GEEKS"; //count should be 1
	     int count =0;
	     //searching the first character of the string in the first row
	     for(int i=0;i<a.length;i++) {
	    	 for(int j=0;j<a.length;j++) {
	    		 //System.out.print(a[i][j]+" ");
	    		 if(a[i][j] == str.charAt(0)) {
	    			 count= count+findString(str,a,i,j);
	    		 }
	    	 }
	     }
	     System.out.println(count);

	}
	public static int findString(String str, char a[][], int i,int j) {
		int countup=0;
		int countright=0;
		int countdown=0;
		int countleft=0;
		System.out.println("for i= "+i+" and j= "+j);
		if(i<str.length()-1){	//row number is less than string length - no need to check in upward direction.
			countup=0;
		}
		else { //check upward
			countup=stringExist(a,str,i,j,1);
			System.out.println("countup: "+countup);
		}
		
		if(i> a.length-str.length()){	//last row - no need to check in downward direction
			countdown=0;
		}
		else { //check downward
			countdown=stringExist(a,str,i,j,3);
			System.out.println("countdown: "+countdown);
		}
		
		if(j<str.length()-1){	//first column - no need to check in left direction
			countleft=0;
		}
		else { //check leftward
			countleft=stringExist(a,str,i,j,4);
			System.out.println("countleft: "+countleft);
		}
		
		if(j>a[0].length-str.length()){	//last column - no need to check in rightward direction
			countright=0;
		}
		else { //check rightward
			countright=stringExist(a,str,i,j,2);
			System.out.println("countright: "+countright);
		}
		System.out.println(	"total count: "+(countup+countright+countdown+countleft));
		return countup+countright+countdown+countleft;
	}
	
	public static int stringExist(char a[][], String str, int i, int j,int direction) {
		if(direction ==1) {
			for(int k=0;k<str.length();k++) {
				if(str.charAt(k) != a[i-k][j]) {
					return 0;
				}
			}
			return 1;
		}
		if(direction ==3) {
			for(int k=0;k<str.length();k++) {
				if(str.charAt(k) != a[i+k][j]) {
					return 0;
				}
			}
			return 1;
		}
		if(direction ==2) {
			for(int k=0;k<str.length();k++) {
				if(str.charAt(k) != a[i][j+k]) {
					return 0;
				}
			}
			return 1;
		}
		if(direction ==4) {
			for(int k=0;k<str.length();k++) {
				if(str.charAt(k) != a[i][j-k]) {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}

}
