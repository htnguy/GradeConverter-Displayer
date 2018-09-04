package cecs220Assignemnt4;


import java.io.File;
import java.util.Scanner;

public class LetterGradeConverter {
	// private variables;
	private int[] intGrades;
	private char[] letterGradeList;
	private int actualLength;
	// constructor for initializing intGrades array
	public LetterGradeConverter(File file, int size) {
		int i = 0;
		this.intGrades = new int[size];
		this.actualLength = size;
		try {
			Scanner scan = new Scanner(file);
			// adding intGrades into the array of integers
			while(i < size) {
				this.intGrades[i] = scan.nextInt();
				i++;
			}
			letterGradeConverter(this.intGrades, size); // converting intGrade to letterGrade
			scan.close();
			
		}catch(Exception err) {
			System.out.println("There was an issue opening the file here is the error "+ err.getMessage());
		}
		 
	}
	// Method for converting to letterGrade
	private  void letterGradeConverter(int[] intGrades, int size ) {
		this.letterGradeList = new char[size];
		int grade;
		// looping through array of intGrades and assigning letterGrades based on the value of the intGrade
		for(int i = 0; i < size; i++) {
			grade = intGrades[i];
			if(grade>= 90) {
				this.letterGradeList[i] = 'A';
			}else if(grade<90 && grade>= 80) {
				this.letterGradeList[i]  = 'B';
			}else if(grade <80 && grade>= 70) {
				this.letterGradeList[i] = 'C';
			}else if(grade<70 && grade>=60) {
				this.letterGradeList[i] = 'D';
			}else {
				this.letterGradeList[i] = 'F';
			}
		}
	}
	// returning a nicely formatted table containing the intGrades and the corresponding letter grade
	public String toString() {
		String strFinal = "Number Grade    || " + " Letter Grade \n";
		
		// concatenating the formatted string into one big string
		for(int i = 0; i<this.actualLength; i ++) {
			strFinal+= "     "+this.intGrades[i] +"         ||       "+ this.letterGradeList[i]+ "\n";
		}
		return strFinal;
	}
	// check if two LetterGradeConverter are equal based on their LetterGradelist
	public boolean equal(LetterGradeConverter conv2) {
		boolean isEqual = true;
		int i = 0;
		// if the two objects have arrays of the same size
		if(this.actualLength == conv2.getLength()) {
			while( i < this.actualLength) {
				if(this.letterGradeList[i] != conv2.getLetterGradeList()[i]) {
					isEqual = false;
					break;
				}
				i++;
			}
		}else { // if they are not the same size then the arrays can not be equal
			isEqual = false;
		}
		return isEqual;
		
	}
	// accessor 
	public int getLength() {
		return this.actualLength;
	}
	public char[] getLetterGradeList() {
		return this.letterGradeList;
	}
	public int[] getIntGradeList() {
		return this.intGrades;
	}
}

