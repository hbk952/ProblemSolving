package String;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

	public static void main(String[] args) {
		String a="abc";	//Number of elements = 2^n = 8 = {[],[a],[b],[c],[ab],[bc],[ac],[abc]}
		//StringBuilder output =new StringBuilder();
		List<String> finaloutput = new ArrayList<String>();
		findSet(a,"",finaloutput);
		System.out.println(finaloutput);

	}
	
	public static void findSet(String s, String output,List<String> finaloutput) {
		if(s.length()==0) {
			
			System.out.println(output);
			finaloutput.add(output);
			return;
		}
		// We add adding 1st character in string
		findSet(s.substring(1), output + s.charAt(0),finaloutput);
 
        // Not adding first character of the string because the concept of subsequence either character will present or not
		findSet(s.substring(1), output,finaloutput);
	}

}
