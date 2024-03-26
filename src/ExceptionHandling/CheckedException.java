package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {

	public static void main(String[] args) throws IOException{
		    {
		        // Creating a file and reading from local repository
		        FileReader file = new FileReader("C:\\Users\\harish.gupta\\Desktop\\exception.txt");
		 
		        // Reading content inside a file
		        BufferedReader fileInput = new BufferedReader(file);
		 
		        for (int counter = 0; counter < 3; counter++)
		            System.out.println(fileInput.readLine());
		 
		        // Closing all file connections- Good practice to avoid any memory leakage
		        fileInput.close();
		    }

	}

}
