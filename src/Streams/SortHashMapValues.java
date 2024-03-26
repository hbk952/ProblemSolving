package Streams;

import java.util.HashMap;
import java.util.Map;

public class SortHashMapValues {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer,String>();
        map.put(1,"Harish");
        map.put(3,"Ravi");
        map.put(5,"Rahul");
        map.put(4,"Kishan");
        
        map.entrySet().stream().sorted(Map.Entry.<Integer,String>comparingByValue().reversed()) 
        .limit(10) 
        .forEach(System.out::println); 
        

	}

}
