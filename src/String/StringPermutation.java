package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//find permutation of s1 and then check if any possible permutation of s1 lies in s2 or not.
public class StringPermutation {

	
	    //Function for swapping the characters at position I with character at position j  
	    public static String swapString(String a, int i, int j) {  
	        char[] b =a.toCharArray();  
	        char ch = b[i];  
	        b[i] = b[j];  
	        b[j] = ch;  
	        return String.valueOf(b);  
	    }  
	      
	    public static void main(String[] args)  
	    {  
	        String s1 = "abc";  
	        String s2 = "eidbaooo";
	        int len = s1.length();  
	        List permutations = new ArrayList();
	        System.out.println("All the permutations of the string are: ");  
	        generatePermutation(s1, 0, len,permutations);  
	        System.out.println(permutations);
	        boolean ifExist = checkIfSubStringExist(s1,s2,permutations);
	        System.out.println(ifExist);
	    }  
	      
	    //Function for generating different permutations of the string  
	    public static void generatePermutation(String str, int start, int end, List permutations)  
	    {  
	        //Prints the permutations  
	        if (start == end-1) {
	        	permutations.add(str);
	        }  
	        else  
	        {  
	            for (int i = start; i < end; i++)  
	            {  
	                //Swapping the string by fixing a character  
	                str = swapString(str,start,i);  
	                //Recursively calling function generatePermutation() for rest of the characters   
	                generatePermutation(str,start+1,end, permutations);  
	                //Backtracking and swapping the characters again.  
	                str = swapString(str,start,i);  
	            }  
	        }  
	    }  
	    
	    public static boolean checkIfSubStringExist(String s1,String s2,List permutations) {
	    	int windowSize = s1.length();
	    	for(int i=0; i<=s2.length()-windowSize; i++) {
	    		String subStr = s2.substring(i, i+windowSize);
	    		System.out.println(subStr);
	    		if(permutations.contains(subStr)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }

}



