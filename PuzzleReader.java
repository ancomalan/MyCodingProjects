//alan vo 
//occc fall 2023
//advanced java
//square puzzle reader
//C:\Users\bvo10\OneDrive\Desktop\AdvancedJava\PuzzleReader\src\puzzle.txt

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

public class PuzzleReader {

	//function to display square table before conversion
	public static void displayTable (int[][] theTable) {
		System.out.println();
		for (int r = 0; r < theTable.length; r++) {
			for (int c = 0 ; c < theTable[r].length; c++) {
				System.out.printf("%3c", theTable[r][c]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	//function to display converted square table
	public static void displayTable (String[][] theTable) {
		System.out.println();
		for (int r = 0; r < theTable.length; r++) {
			for (int c = 0 ; c < theTable[r].length; c++) {
				System.out.printf("%3s", theTable[r][c]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println ("Welcome to Square Puzzle Reader!");
		String fileName = "";

		//command prompt for file name 
		if (args.length == 1) {
			fileName = args[0];
		}
		//otherwise, prompt user for file name
		else {
			System.out.print ("Please enter a file name: ");
			Scanner s = new Scanner (System.in);
			fileName = s.nextLine();
			s.close(); //close scanner object 
		}

		try{
			Scanner f = new Scanner (new File(fileName));
			Vector<Character> vector = new Vector<>(); //create a new character vector to store characters from file 

			//add characters from file to vector
			while (f.hasNext()){
				vector.add(f.next().charAt(0)); 

			}

			//validate if number of entries in vector is perfect square, otherwise exit program
			if (Math.pow(Math.sqrt((double)vector.size()),2) == vector.size()) {

				//Use 2D array to display initial puzzle before characters are converted to decimal
				int numRows = (int) Math.sqrt(vector.size()); //rows of table
				int numCols = (int) Math.sqrt(vector.size()); //columns of table
				int [][] myTable = new int [numRows][numCols]; //create 2D array to store elements of vector 
				int count = 0; //accumulator variable to access all elements in vector

				//use for loop to assign each vector element character to myTable
				for (int r = 0 ; r < numRows ; r++) {
					for (int c = 0; c < numCols ; c++) {
						myTable[r][c] = vector.elementAt(count);
						count++; //so that can loop through all elements 
					}
				}
				System.out.println();
				System.out.println("Before Conversion:");
				System.out.println();
				displayTable(myTable); //call display table function to print characters as table before conversion
				System.out.println();

				Vector<String> vector2 = new Vector<>(); //create new string vector to store decimal value of characters
				String charSymbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //all the possible characters
				int valueDecimal = 0; // to store decimal value of letter character
				String stringCharacter; //to access string version of character element 
				String stringValueDecimal; //to store new decimal value as string 

				//copy old character vector's elements into new String vector
				for (int i = 0; i < vector.size(); i++) {
					vector2.add(vector.elementAt(i).toString()); //toString to convert char element into string element to be stored in new string vector
					stringCharacter = vector2.elementAt(i); //access the string character 


					//change to appropriate decimal value for letter characters (a-z)
					if (Character.isLetter(stringCharacter.charAt(0))) {
						valueDecimal = charSymbols.indexOf(stringCharacter.toUpperCase());//change to upper-case so that not case sensitive
						/*now have correct decimal conversion for letters as an integer
						need to change it back into a string and store it in new string vector */
						stringValueDecimal= String.valueOf(valueDecimal); //change converted integer value back into string
						vector2.set(i, stringValueDecimal); //store decimal value back into new vector 

					}
					//keep digits (0-9) the same 
					else if (Character.isDigit(stringCharacter.charAt(0))) {
						valueDecimal = charSymbols.indexOf(stringCharacter);
						stringValueDecimal= String.valueOf(valueDecimal);
						vector2.set(i, stringValueDecimal);
					}
					//if not a part of character symbols (not a letter or digit), set to blank space
					else {
						stringCharacter = " "; //store a blank space
						vector2.set(i, stringCharacter);
					}

				}

				//display solved puzzle after characters are changed to correct decimal values
				int numRows2 = (int) Math.sqrt(vector2.size()); //rows of second table
				int numCols2 = (int) Math.sqrt(vector2.size()); //columns for second table 
				String [][] myTable2 = new String [numRows2][numCols2]; //create 2D string array to store new vector's string elements 
				int count2 = 0; //accumulator variable to access all string elements in vector2

				//use for loop to assign each string vector element to myTable2
				for (int r = 0 ; r < numRows2 ; r++) {
					for (int c = 0; c < numCols2 ; c++) {
						myTable2[r][c] = (vector2.elementAt(count2));
						count2++;
					}
				}
				System.out.println("After Conversion: ");
				System.out.println();
				displayTable(myTable2); //method overloading (call new display table function to print strings after conversion) 
			}
			else {
				System.out.println ("This is not a valid square!");
				System.exit(0);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File " + fileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
