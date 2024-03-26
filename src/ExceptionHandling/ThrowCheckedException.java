package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowCheckedException {

	public static void main(String[] args) {
		try {
			method();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
			System.out.println(e);
		}

	}
	public static void method() throws FileNotFoundException {
		FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");  
        BufferedReader fileInput = new BufferedReader(file);  
        throw new FileNotFoundException();
	}
}
