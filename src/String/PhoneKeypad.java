package String;

import java.util.ArrayList;
import java.util.List;
//if you press 23 - possible strings generated - ad,ae,af,bd,be,bf,cd,ce,cf
public class PhoneKeypad {

	public static void main(String[] args) {
		String mapping[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		int digits = 23;
		List <String>finalOutput = new ArrayList<String>();
		System.out.println("String Equivalent to first digit ("+(digits/10)+") = "+mapping[digits/10]);
		System.out.println("String Equivalent to second digit ("+(digits%10)+") = "+mapping[digits%10]);
		possibleCombinations(mapping[digits/10],mapping[digits%10], finalOutput);
		System.out.println("posible string combinations can be generated as: "+finalOutput);

	}
	public static void possibleCombinations(String a, String b, List<String> finalOutput) {
		for(String s3: a.split("")) {
			for(String s4: b.split("")) {
				finalOutput.add(s3+s4);
			}
		}
	}

}
