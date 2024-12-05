package String;
import java.util.ArrayList;

//Split the binary string into substrings with equal number of 0s and 1s
//str = �0100110101� - �01�, �0011�, �01� and �01�.
public class SplitBinaryString {

	public static void main(String[] args) {
		String s = "0111100010";
		ArrayList<String> al = new ArrayList<String>();
		int count_zero =0;
		int count_one = 0;
		int subString_startIdx = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				count_zero++;
				
			}
			else if(s.charAt(i)=='1') {
				count_one++;
			}
			if(count_zero==count_one) {
				String temp=s.substring(subString_startIdx, i); //create substring excluding i
				temp = temp+s.charAt(i); //ith charater included in string
				al.add(temp);
				count_one =0;
				count_zero=0;
				subString_startIdx = i+1;
			}
		}
		System.out.println(al);

	}

}
