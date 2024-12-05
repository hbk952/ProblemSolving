package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
public class CommonElementsInArrays {

	public static void main(String[] args) {
		int a[]= {1, 5, 10, 20, 40, 80};
		int b[] = {6, 7, 20, 80, 100};
		int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
		List<Integer> al = new ArrayList<Integer>();
		al = commonElementsUsingMap(a,b,c,al);
		//System.out.println(al);
	}
	public static List<Integer> commonElementsUsingMap(int a[], int b[], int c[], List<Integer> al) {
		//put a[] in MapA
		 Map<Integer,Integer> mapA = new HashMap<Integer,Integer>();
	        for(int i=0;i<a.length;i++){
	            if(mapA.containsKey(a[i])){
	                mapA.put(a[i],mapA.get(a[i])+1);
	            }else{
	                mapA.put(a[i],1);
	            }
	        }
	      //put b[] in MapB
	     Map<Integer,Integer> mapB = new HashMap<Integer,Integer>();
	        for(int j=0;j<b.length;j++){
	            if(mapB.containsKey(b[j])){
	                mapB.put(b[j],mapB.get(b[j])+1);
	            }else{
	                mapB.put(b[j],1);
	            }
	        }
	      //put elements of c[] in MapC if those are present in mapA or mapB   
	     Map<Integer,Integer> mapC = new HashMap<Integer,Integer>();
	        for(int k=0;k<c.length;k++){
	            if(mapA.containsKey(c[k]) && mapB.containsKey(c[k]) && mapC.containsKey(c[k])){
	                mapC.put(c[k],mapC.get(c[k])+1);
	            }
	            else if(mapA.containsKey(c[k]) && mapB.containsKey(c[k])) {
	            	mapC.put(c[k],1);
	            }
	           
	        }
	        
	    Set<Integer> s = mapC.keySet();
	    al.addAll(s);
		return al;
	}

}
