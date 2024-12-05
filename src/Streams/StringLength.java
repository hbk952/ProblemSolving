package Streams;

import java.util.Arrays;
import java.util.List;

public class StringLength {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Harish", "Prince", "Aditya");
		int length = strList.stream().mapToInt(String::length).sum();
		System.out.println(length);

	}

}
