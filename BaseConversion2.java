//alan vo 
//occc fall 2023
//advanced java
//base conversion

import java.util.Scanner; //to read input from the keyboard
import java.math.BigInteger;//import big integer class
import java.math.*;
public class BaseConversion2 {

	public static void main(String[] args) {

		//declare variables
		String valueToConvert = ""; //variable to store value to be converted
		int initialBase = 0; //initial base of value the user wants to convert from
		int desiredBase = 0; //base that the user wants to convert to
		Scanner input = new Scanner(System.in); //create scanner object to read input from user

		//greet user
		System.out.println("Welcome to the Base Conversion Program!");

		//check first to see if user used command line to input values
		//if the user inputed all 3 command line parameters, use them
		if (args.length == 3) {
			valueToConvert = args[0].toUpperCase(); 
			initialBase = Integer.parseInt(args[1]); //convert string to integer 
			desiredBase = Integer.parseInt(args[2]); //convert string to integer
		}

		//If there are command line parameters but fewer than three of them, prompt the user for any remaining parameters
		else if (args.length == 2) {
			valueToConvert = args[0].toUpperCase();
			initialBase = Integer.parseInt(args[1]);
			System.out.print("Please enter the desired base of the value to be converted (2-36): "); 
			desiredBase = input.nextInt();
		}
		else if (args.length == 1) {
			valueToConvert = args[0].toUpperCase();
			System.out.print("Please enter the initial base of the value to be converted (2-36): ");
			initialBase = input.nextInt();
			System.out.print("Please enter the desired base of the value to be converted (2-36): ");
			desiredBase = input.nextInt();
		}
		//If there are more than three command-line parameters, give a warning and process on the first three
		else if (args.length > 3) {
			System.out.println("Extra Parameters Ignored"); 
			valueToConvert = args[0]; 
			initialBase = Integer.parseInt(args[1]);
			desiredBase = Integer.parseInt(args[2]);
		}
		//Otherwise, if there are no command-line parameters at all, prompt the user for all them using scanner
		else {
			System.out.print("Please enter a value that you would be converted as a string: ");//prompt the user for value to convert 
			valueToConvert = input.nextLine().toUpperCase();
			System.out.print("Please enter the initial base of the value to be converted (2-36): "); //prompt user for initial base value 
			initialBase = input.nextInt();
			System.out.print("Please enter the desired base of the value to be converted (2-36): "); //prompt user for desired base value
			desiredBase = input.nextInt();
		}

		//invoke the validation function to ensure string is valid in initial base
		if (isValidInteger(valueToConvert, initialBase)) {
			//call the conversion function 
			System.out.println ("New String Conversion: " + convertInteger(valueToConvert, initialBase, desiredBase));
		} 
	}


	//function to check validity of all characters in the String 
	/* I was stuck for hours on how to validate for the letters (I knew that the characters had to be one less than the base, just did not know how to implement it)
	so I received inspiration using this YouTube video: https://www.youtube.com/watch?v=E1kOFHhNij4 */
	public static boolean isValidInteger(String theValue, int theBase){
		char characterInString; //to store each character as for loop progresses
		boolean flag = true; //variable used to return whether true or false

		//use for loop to traverse through all the characters of the string 
		for (int i = 0 ; i < theValue.length(); i++) {
			characterInString = theValue.toUpperCase().charAt(i); //just in case, convert character to upper-case, to make it easier with letter characters

			/*check to see if character is a number character ('0'-'9'). If the distance between the character '0' and the character being checked is greater than or equal to the base passed in, 
			return false and exit program (because the max character in a given base is one less than the base)*/
			if (Character.isDigit(characterInString) && characterInString - '0' >= theBase) {
				System.out.println("Error! The digit " + characterInString + " is not valid in the base of " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}

			/*check to see if character is letter character ('A'-'Z'). If the distance between the character 'A' and the character being checked is 
			greater than or equal to the base given, return false and exit program. Add 10 to distance to account for 10 number digits ('0'-9') that came before first hexadecimal letter digit*/
			else if (Character.isLetter(characterInString) && (characterInString - 'A') + 10 >= theBase){ 
				System.out.println("Error! The digit " + characterInString + " is not valid in the base of " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}
			//check for special characters 
			else if (!Character.isDigit(characterInString) && !Character.isLetter(characterInString)) {
				System.out.println("Error! The digit " + characterInString + " is not valid in the base of " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}
		}
		return flag; //return boolean result 
	}


	//function to convert string
	/*After yesterday's class I received a lot of help from Hailey on how to do the string conversion function. This is her code, which made way more sense
	than the code that I found in the video and something that I actually understand*/


	public static String convertInteger(String theValue, int initialBase, int finalBase){
		BigInteger valueDecimal = new BigInteger("0");
		int temp = 0; 
		String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //all the possible characters 
		String newValue = "";
		
		//convert to base 10, formula: valueOfDigit * (initialBase)^placeValue) 
		for (int i = 0 ; i < theValue.length(); i++) {
			valueDecimal = valueDecimal.add(BigInteger.valueOf(symbols.indexOf(theValue.charAt(i))).multiply(BigInteger.valueOf(initialBase).pow(theValue.length()-(i+1)))) ;
		}
		
		//convert to finalBase
		while (valueDecimal != BigInteger.valueOf(0)){
			temp = valueDecimal.mod(BigInteger.valueOf(finalBase)).intValue();
			valueDecimal = valueDecimal.divide(BigInteger.valueOf(finalBase));
			newValue = symbols.charAt(temp) + newValue;
		}
		
		return newValue; 
	
		
		
		
		


		

	}

}



















