package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SkipLimit {

	public static void main(String[] args) {
		List<String> arr = new ArrayList(); 
        
        arr.add("geeks"); 
        arr.add("for"); 
        arr.add("geeks"); 
        arr.add("computer"); 
        arr.add("science");
		arr.stream().skip(2).forEach(System.out::println);
		
		arr.stream().limit(2).forEach(System.out::println);

	}

}
