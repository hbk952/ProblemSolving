package Streams;

import java.util.Arrays;
import java.util.List;

public class MapStream {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		int sumOfEvenNumbers = numbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfEvenNumbers);
		numbers.stream().map(number -> number * 3).forEach(System.out::println); 
	}

}
