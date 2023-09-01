import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.math.BigInteger;
//C:\Users\bvo10\OneDrive\Desktop\AdvancedJava\PasswordChecker\BaseConversionFile.txt
//This program reads from a file converting all valid strings into decimal and finds the sum of all of them 
public class BaseConversionQuiz {

	public static void main(String[] args) {
		System.out.println("Welcome to the Base Conversion Quiz!");
		System.out.println(); 
		String fileName = "";
		BigInteger totalDecimalValue = new BigInteger ("0"); //running total for sum of decimals
		
		
		if (args.length == 1){
			fileName = args[0];
		}
		else {
			System.out.print("Please enter file name: ");
			Scanner s = new Scanner(System.in);
			fileName = s.nextLine();
		}
		try{
			Scanner f = new Scanner (new File(fileName));
			while (f.hasNextLine()){
				String valueToBeConverted = f.next().toUpperCase();
				int base = Integer.parseInt(f.next());
				if (isValidInteger(valueToBeConverted, base)) {
					//convert to decimal
					totalDecimalValue = totalDecimalValue.add(convertInteger (valueToBeConverted, base));		
					}
				System.out.println("The total decimal value of the file is " + totalDecimalValue);
		
		}

		}
		catch (FileNotFoundException e){
			System.out.println("File " + fileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}

}
	
	public static boolean isValidInteger(String theValue, int theBase){
		char characterInString; //to store each character as for loop progresses
		boolean flag = true; //variable used to return whether true or false

		//use for loop to traverse through all the characters of the string 
		for (int i = 0 ; i < theValue.length(); i++) {
			characterInString = theValue.toUpperCase().charAt(i); //just in case, convert character to upper-case, to make it easier with letter characters

			/*check to see if character is a number character ('0'-'9'). If the distance between the character '0' and the character being checked is greater than or equal to the base passed in, 
			return false and exit program (because the max character in a given base is one less than the base)*/
			if (Character.isDigit(characterInString) && characterInString - '0' >= theBase) {
				flag = false;
				break;
			}

			/*check to see if character is letter character ('A'-'Z'). If the distance between the character 'A' and the character being checked is 
			greater than or equal to the base given, return false and exit program. Add 10 to distance to account for 10 number digits ('0'-9') that came before first hexadecimal letter digit*/
			else if (Character.isLetter(characterInString) && (characterInString - 'A') + 10 >= theBase){ 
				flag = false;
				break;
			}
			//check for special characters 
			else if (!Character.isDigit(characterInString) && !Character.isLetter(characterInString)) {
				flag = false;
				break;
			}
			else {
				flag = true;
			}
		}
		return flag; //return boolean result 
	


		

	}
	
	public static BigInteger convertInteger(String theValue, int initialBase){
		BigInteger valueDecimal = new BigInteger("0");
		String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //all the possible characters 
		
		
		//convert to base 10, formula: valueOfDigit * (initialBase)^placeValue) 
		for (int i = 0 ; i < theValue.length(); i++) {
			valueDecimal = valueDecimal.add(BigInteger.valueOf(symbols.indexOf(theValue.charAt(i))).multiply(BigInteger.valueOf(initialBase).pow(theValue.length()-(i+1)))) ;
		}
		System.out.println(valueDecimal);
	
		
	
		
		return valueDecimal; 
	
		
		
		
		


		

	}
	
	
	
	}
