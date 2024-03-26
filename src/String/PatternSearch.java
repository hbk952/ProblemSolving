package String;

import java.util.ArrayList;

//Rabin-karp algo - unlike the Naive algorithm, the Rabin Karp algorithm matches the hash value of the pattern with the hash value of the current substring of text, and if the hash values match then only it starts matching individual characters
//The hash value is calculated using a rolling hash function, which allows you to update the hash value for a new substring by efficiently removing the contribution of the old character and adding the contribution of the new character
//Input:  T[] =  “AABAACAADAABAABA”, P[] =  “AABA”
//output: Pattern found at index 0, index 9 and index 12
public class PatternSearch {

	public static void main(String[] args) {
		String T = "AABAACAADAABAABA";
		String P = "AABA";
		//String T = "THIS IS A TEST TEXT";
		//String P = "TEST";
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=0;i<=T.length()-P.length();i++) {
			if(T.substring(i, i+4).equals(P)) {
				ans.add(i);
			}
		}
		System.out.println(ans);

	}

}
