package String;
//Return the minimum number of operations required to convert s to t
//Possible operations - 
//1. Insert a character at any position of the string.
//2. Remove any character from the string.
//3. Replace any character from the string with any other character.

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationToConvertSToT {

	public static void main(String[] args) {
		String s = "gesek";
		String t = "geek";
		System.out.println(mySolution(s,t));

	}
	
	public static int mySolution(String s, String t) {
		if(s.equals(t)) {
        	return 0;
        }
		int operation =0;
		StringBuilder sb = new StringBuilder(s);
		StringBuilder tb = new StringBuilder(t);
		//find frequency of characters is t and s
		Map<Character,Integer> map_t = new HashMap<Character,Integer>();
        for(int i=0;i<tb.length();i++){
            if(map_t.containsKey(tb.charAt(i))){
                map_t.put(tb.charAt(i),map_t.get(tb.charAt(i))+1);
            }else{
                map_t.put(tb.charAt(i),1);
            }
        }
        //if any character is in s but not in t - remove it now only
		Map<Character,Integer> map_s = new HashMap<Character,Integer>();
        for(int i=0;i<sb.length();i++){
        	if(map_t.containsKey(sb.charAt(i))) {
        		if(map_s.containsKey(sb.charAt(i))){
                    map_s.put(sb.charAt(i),map_s.get(sb.charAt(i))+1);
                }else{
                    map_s.put(sb.charAt(i),1);
                }
        	}
        	else {
        		sb.deleteCharAt(i);
        		operation++;
        	}   
        }
        if((sb.toString()).equals(tb.toString())) {
        	return operation;
        }
        
		//now both strings have same chars
		//replace operation only required.
		
		return operation;
	}
}