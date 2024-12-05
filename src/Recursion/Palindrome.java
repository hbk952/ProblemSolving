package Recursion;

public class Palindrome {

	public static void main(String[] args) {
		String  str = "BookkooB";
		boolean result = isPalindrome(str,0,str.length()-1);
		if(result) {
			System.out.println("The string is Palindrome");
		}
		else {
			System.out.println("The String is not Palindrome");
		}

	}
	public static boolean isPalindrome(String str, int startIndex, int endIndex) {
		if(startIndex>endIndex) {
			return true;
		}
		if(str.charAt(startIndex) != str.charAt(endIndex)) {
			return false;
		}
		else {
			startIndex++;
			endIndex--;
			return isPalindrome(str,startIndex,endIndex);
		}
		
	}

}
