package String;
//Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
//NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
//s = "abab" - o/p= 2 - ab
//s = "aaaa" - o/p =3 - aaa
public class LongestPrefixSuffix {

	public static void main(String[] args) {
		String s = "abab";
		String result = findLongestPrefix(s);
		System.out.println(result);
		
	}
	public static String findLongestPrefix(String s) {
		if(s.length()<=1) {
			return "No result - string length <1";
		}
		if(s.indexOf(s.substring(0, 1)) == s.lastIndexOf(s.substring(0, 1))) { //if first character existed only once
			return "No result - first character appeared only once";
		}
		if(s.indexOf(s.charAt(s.length()-1)) == s.lastIndexOf(s.charAt(s.length()-1))) { //if last character existed only once
			return "No result - last character appeared only once";
		}
		//check the last appearence of the first character within range [middle,end-1]
		int middle=s.length()/2;
		int first_character_last_appearence = s.lastIndexOf(s.charAt(0), middle);
		System.out.println("first_character_last_appearence: "+first_character_last_appearence);
		//check the first appearence of the last chahracter within range [1,middle]
		int last_character_first_appearence = s.indexOf(s.charAt(s.length()-1), 1);
		System.out.println("last_character_first_appearence: "+last_character_first_appearence);
		//if it appear at index<= middle then check the subsequent characters from [0,last_character_first_appearence] == [first_character_last_appearence,end]
		if(last_character_first_appearence <= middle && first_character_last_appearence>=middle) {
			String result = checkSubsequentCharacter(s,last_character_first_appearence,first_character_last_appearence);
			return result;
		}
		
		
		return "No result";
		
	}
	public static String checkSubsequentCharacter(String s, int last_character_first_appearence, int first_character_last_appearence) {
		if((last_character_first_appearence-0) == (s.length()-1-first_character_last_appearence)) { //if window length is same
			for(int i=0;i<=last_character_first_appearence;i++) {
				if(s.charAt(i) != s.charAt(first_character_last_appearence+i)) {
					return "No result - subsequent characters are not same";
				}
			}
		}
		else {
			return "No result - window length are not same";
		}
		String result = s.substring(0, last_character_first_appearence+1);
		return result;
	}

}
