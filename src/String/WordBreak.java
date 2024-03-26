package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String A = "ilikesamsung";
		String str_arr[] = A.split("");
		String temp = "";
		String B[] = { "i", "like", "sam","sung", "samsung", "mobile","ice","cream", "icecream", "man", "go", "mango" };
		List<String> BL = new ArrayList<String>(Arrays.asList(B));
		Set<String> ans = new HashSet<String>();
		for(int i=0;i<str_arr.length;i++) {
			//add to make a word and then search
			temp=temp.concat(str_arr[i]);
			
			//if the temp present in BL - add it to ans
			if(BL.contains(temp)) {
				ans.add(temp);
				temp="";//re-initialse the string		
			}
			
		}
		System.out.println(ans);
		

	}
	public static boolean checkListContainsWordStartsWithString(List<String> BL,String temp) {
		for(String s : BL) {
			if(s.startsWith(temp)) {
				return true;
			}
		}
		return false;
	}
}
