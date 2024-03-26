package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
public class MinMaxStream {


	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-9,-9, -18, 0, 25, 4); 
		Integer min_num = list.stream().min(Integer::compare).get();
		System.out.println("minimum number in the list: "+ min_num);
		
		// Using Stream.min() with reverse comparator to get maximum element. 
        Optional<Integer> max_num = list.stream().min(Comparator.reverseOrder()); 
        System.out.println("maximum number in the list: "+max_num.get());
        
        //minimum 3 elements
        System.out.println("minimum 3 number in the list: ");
        list.stream().sorted().limit(3).forEach(System.out::println);
        
        //minimum 3 dictinct elements
        System.out.println("minimum 3 distinct number in the list: ");
        list.stream().sorted().distinct().limit(3).forEach(System.out::println);
        
        String[] array = { "Geeks", "for", "GeeksforGeeks", "GeeksQuiz" };
        // The Comparator compares the strings based on their last characters and returns the minimum value accordingly. 
        Optional<String> MIN = Arrays.stream(array).min((str1, str2) ->  
                    Character.compare(str1.charAt(str1.length() - 1), str2.charAt(str2.length() - 1))); 
  
        // If a value is present, isPresent() will return true 
        if (MIN.isPresent())  
            System.out.println(MIN.get());  
        else
            System.out.println("-1");  
 
	}

}
