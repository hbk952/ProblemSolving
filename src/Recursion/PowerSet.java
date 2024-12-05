package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//same as subsequence in Strings
public class PowerSet {

	public static void main(String[] args) {
		int a[] = {1,2,3};	//Number of elements = 2^n = 8 = {[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]}
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> finaloutput = new ArrayList<Integer>();
		int index=0;
		findSet(a,output,index,finaloutput);
		System.out.println(finaloutput);
		
		

	}
	public static void findSet(int a[], List<Integer> output, int index,List<Integer> finaloutput) {
		if(index>=a.length) {
			
			System.out.println(output);
			finaloutput.addAll(output);
			return;
		}
		//exclude elements
		findSet(a,output,index+1,finaloutput);
		//include elements
		int element = a[index];
		output.add(element);
		findSet(a,output,index+1,finaloutput);
	}
	
}
