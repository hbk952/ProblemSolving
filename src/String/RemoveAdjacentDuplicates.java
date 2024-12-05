package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveAdjacentDuplicates {
	static String str = "azxxzy"; //expected output ay such as azxxzy - azzy - ay
	//String is immutable - transforming in string buffer.
	static StringBuffer strb = new StringBuffer(str);		
	public static void main(String[] args) {
		
		for(int i=0; i<strb.length()-1;i++) {
			if(strb.charAt(i)==strb.charAt(i+1) ) {
				removeDuplicates(strb,i,i+1);
				i=-1;
			}
			
			
			
		}
		System.out.println(strb);
	}
	public static void removeDuplicates(StringBuffer strb,int dupCharStartIndex,int dupCharEndIndex) {
		if(dupCharEndIndex == strb.length()-1) {	//if end index is the last string character - delete till end and then delete end
			strb = strb.delete(dupCharStartIndex, dupCharEndIndex);
			strb.deleteCharAt(dupCharEndIndex);
		}
		else {	//else delete till end character index +1 because strb.delete is exclusive of last index
			strb = strb.delete(dupCharStartIndex, dupCharEndIndex+1);
		}
		
	}

}
