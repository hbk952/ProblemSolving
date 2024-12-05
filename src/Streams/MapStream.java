package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		int sumOfEvenNumbers = numbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfEvenNumbers);
		numbers.stream().map(number -> number * 3).forEach(System.out::println); 
		
		//count number of occurence of an element in the array
		int[] a = {4, 3, 2, 7, 8, 2, 3, 1};

        Map<Integer, Long> duplicatesCount = Arrays.stream(a)
        									 .boxed() // Convert int[] to Stream<Integer>
        									 .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        duplicatesCount.forEach((num, count) -> {
            if (count > 1) {
                System.out.println("Number: " + num + ", Count: " + count);
            }
        });
	}

}
