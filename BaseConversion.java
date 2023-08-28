//alan vo 
//occc fall 2023
//advanced java
//base conversion

import java.util.Scanner; //to read input from keyboard
public class BaseConversion {

	public static void main(String[] args) {

		String valueToConvert = ""; //variable to store value to be converted
		int initialBase = 0; //initial base of value the user wants to convert from
		int desiredBase = 0; //base that the user wants to convert to
		Scanner input = new Scanner(System.in); //create scanner object to read input from user

		//greet user
		System.out.println("Welcome to the Base Conversion Program!");

		//check first to see if user used command line to input variable values; if the user inputed all 3 command line parameters, use them
		if (args.length == 3) {
			valueToConvert = args[0]; 
			initialBase = Integer.parseInt(args[1]); //convert string to integer 
			desiredBase = Integer.parseInt(args[2]); //convert string to integer
		}

		//If there are command line parameters but fewer than three of them, prompt the user for any remaining parameters
		else if (args.length == 2) {
			valueToConvert = args[0];
			initialBase = Integer.parseInt(args[1]);
			System.out.print("Please enter the desired base of the value to be converted (2-36): "); 
			desiredBase = input.nextInt();
		}
		else if (args.length == 1) {
			valueToConvert = args[0];
			System.out.print("Please enter the initial base of the value to be converted (2-36): ");
			initialBase = input.nextInt();
			System.out.print("Please enter the desired base of the value to be converted (2-36): ");
			desiredBase = input.nextInt();
		}
		//If there are more than three command-line parameters, give a warning and process on the first three
		else if (args.length > 3) {
			System.out.println("Extra parameters ignored...processing on the first three."); 
			valueToConvert = args[0]; 
			initialBase = Integer.parseInt(args[1]);
			desiredBase = Integer.parseInt(args[2]);
		}
		//Otherwise, if there are no command-line parameters at all, prompt the user for all them using scanner object
		else {
			System.out.print("Please enter a string value that you would like to be converted: ");//prompt the user for value to convert 
			valueToConvert = input.nextLine(); 
			System.out.print("Please enter the initial base of the value to be converted (2-36): "); //prompt user for initial base value 
			initialBase = input.nextInt();
			System.out.print("Please enter the desired base of the value to be converted (2-36): "); //prompt user for desired base value
			desiredBase = input.nextInt();
		}

		//invoke the validation function to ensure string is valid in initial base
		if (isValidInteger(valueToConvert, initialBase)) {
			//call the conversion function to print out new string 
			System.out.println ("New String Conversion: " + convertInteger(valueToConvert, initialBase, desiredBase));
		} 
		input.close();//close scanner 
	}


	//function to check validity of all characters in the String 
	/* I was stuck for hours on how to validate for the letters (I knew that the characters had to be one less than the base, just did not know how to implement it)
	so I received inspiration on how to create the validation function using this very helpful YouTube video: https://www.youtube.com/watch?v=E1kOFHhNij4 */

	public static boolean isValidInteger(String theValue, int theBase){
		char characterInString; //to store each character as the for loop progresses
		boolean flag = true; //variable used to return whether true or false

		//use for loop to traverse through all the characters of the string 
		for (int i = 0 ; i < theValue.length(); i++) {
			characterInString = theValue.toUpperCase().charAt(i); //just in case, convert character to upper-case, to make it easier to deal with letter characters

			/*check to see if character is a number character ('0'-'9'). If the distance between the number character '0' and the number character being checked is greater than or equal to the base passed in, 
			return false and exit program (because the max character in a given base is one less than the base)*/
			if (Character.isDigit(characterInString) && characterInString - '0' >= theBase) {
				System.out.println("Error! The digit " + characterInString + " is not valid in base " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}

			/*check to see if character is letter character ('A'-'Z'). If the distance between the letter character 'A' and the letter character being checked is 
			greater than or equal to the base given, return false and exit program. Add 10 to distance to account for 10 number digits ('0'-9') that came before first hexadecimal letter digit ('A')*/
			else if (Character.isLetter(characterInString) && (characterInString - 'A') + 10 >= theBase){ 
				System.out.println("Error! The digit " + characterInString + " is not valid in base " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}
			//check for special characters 
			else if (!Character.isDigit(characterInString) && !Character.isLetter(characterInString)) {
				System.out.println("Error! The digit " + characterInString + " is not valid in base " + theBase);
				System.exit(0); //exit the program
				flag = false;
			}
		}
		return flag; //return boolean result 
	}


	//function to convert string
	/*I also used the same YouTube video to help me with the conversion function. I understood how to convert everything on paper, but just could not understand 
	how to actually implement everything to code, no matter how much I tried unfortunately. As a result, I watched how the video implemented it and used the same code in my program. 
	Although, it is not my code, I dedicated lots of time to try and understand how everything worked.*/

	public static String convertInteger(String theValue, int initialBase, int finalBase){
		//Convert string from initial base into base 10 (decimal)
		double decimalValue = 0; //running total variable to store final decimal value of string
		char characterDigit; //store character digit as I go through loop
		double decimalDigit = 0; //store decimal value of converted character digit

		//loop through each character of string to be converted
		int Length = theValue.length(); //length of string 

		for (int i = 0; i < Length ; i++) {
			//get the character (0-9 or A-Z)
			characterDigit = Character.toUpperCase(theValue.charAt(Length-1-i)); /*Length-1-i allows the conversion to start from the least significant digit (most right digit). As i increases in the for loop, we are able to get more significant digits (move right to left)*/

			/*get decimal value of character digit. if character is a letter (A-Z), get decimal value by determining distance between 'A' and the letter character being converted (add 10 to account for
			10 number digits ('0'-9') that came before 'A' */
			if (Character.isLetter(characterDigit)) {
				decimalDigit = characterDigit - 'A' + 10; 

			}
			//if character is number (0-9), get decimal value by determining distance between '0' and the number character being converted
			else if (Character.isDigit(characterDigit)) {
				decimalDigit = characterDigit - '0'; 
			}

			decimalValue += decimalDigit * Math.pow(initialBase, i); //Convert to decimal by multiplying decimal digit with corresponding base power(base power starts at 0 and increases by one every loop iteration, because we are moving from right to left)
		} 


		//convert decimal to desired base
		//determine number of digits in new base
		int i = 1; //variable to store amount of digits in newly converted string
		for ( ; Math.pow(finalBase, i) <= decimalValue; i++) {} //i not initialized in the loop because want to be able to access it outside the for loop (scope)

		//use character array to hold characters of new string 
		char [] newString = new char [i]; //now that we know number of digits, declare array with size i

		double power; 
		//start loop from largest power and go to smallest (so that the new string characters are printed left to right)
		for (int p = i-1; p >= 0; p--) {
			//calculate the digit for this power of finalBase
			power = Math.pow(finalBase, p); 
			decimalDigit = Math.floor(decimalValue / power); //divide decimalValue by power to get particular digit that occupies that slot: for instance 300/10^2 = 3
			decimalValue -= decimalDigit * power; //each iteration of loop, remove chunk of value from the digit from particular power of base (remainder)

			//store the digit character into character array
			//index is [i-1-p] so that we can store characters from left to right in character array (most significant to least significant)
			if (decimalDigit <= 9) {
				newString [i-1-p] = (char) ('0' + (int)decimalDigit);//for instance, if decimalDigit is 3, 3 more than the character 0 is '3'
			}
			else {
				newString [i-1-p] = (char) ('A' + (int)decimalDigit - 10); //subtract 10 for the first 10 characters that were numbers (0-9)
			}
		}
		return new String(newString) ; //return newly converted string
	}
}

















