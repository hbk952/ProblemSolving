package String;

public class StringRotation {

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDAB";
		boolean rotated = findRotatedString(s1,s2);
		System.out.println("Strings are rotated : "+ rotated);
		boolean rotated1 = areRotation(s1,s2);
		System.out.println("Strings are rotated : "+ rotated1);
		
	}
	public static boolean areRotation(String s1, String s2) {//concise solution
		// There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
		return (s1.length() == s2.length())
	            && ((s1 + s1).indexOf(s2) != -1);
	}
	
	public static boolean findRotatedString(String s1, String s2) {
		boolean rotated = true;
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int prev_idx = s2.indexOf(s1.charAt(0))-1;
		for(int i=0;i<s1.length();i++) {
			int idx = s2.indexOf(s1.charAt(i)); //find index of the char of s1 in s2.
			//System.out.println(prev_idx+" "+s1.charAt(i)+" "+idx);
			if(idx != prev_idx+1) {	//if next char in s2 is not as same next char in s1 then both are not rotated.
				System.out.println("s2 is not rotated of s1");
				rotated = false;
				return rotated;
			}
			
			if(idx == s1.length()-1) { //current char of s1 is the rotated point in s2 - thus next char of s1 will have index 0 in s2
				prev_idx = -1;
			}
			else {
				prev_idx = idx;
			}
		}
		return rotated;
		
	}

}
