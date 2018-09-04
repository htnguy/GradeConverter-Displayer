package cecs220Assignemnt4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LetterGradeDisplayer {
	// counts the number of line in the file
	public static int countLine(File file)  {
		int count = 0;
		FileReader fReader;
		try {
			fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			// if there is a line increment count by 1
			while((bReader.readLine())!= null) {
				count++;
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("There is an error: File Not Found");
			
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		return count;
	}

	public static void main(String[] args) {
		String fileName, fileName2;
		Scanner scan  = new Scanner(System.in);
		// getting the file names and initializing File objects
		System.out.println("Enter the first file name");
		fileName = scan.nextLine() + ".txt";
		System.out.println("Enter the second file name");
		fileName2 = scan.nextLine() + ".txt";
		File file = new File(fileName);
		File file2  = new File(fileName2);
		
		// using a method call countLine enhances the scalability of the the application
		// to handle large files without needing to count the number of lines
	LetterGradeConverter conv1 = new LetterGradeConverter(file, countLine(file));
	LetterGradeConverter conv2 = new LetterGradeConverter(file2, countLine(file2));
	System.out.println(" File 1: \n" +conv1.toString());
	System.out.println("File 2: \n" +conv2.toString());

	System.out.println( "the two letter grade list are equal: "+conv1.equal(conv2)); 
	
		scan.close();

	}

}

