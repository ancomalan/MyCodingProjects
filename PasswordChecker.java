//alan vo 
//occc fall 2023 
//advanced java
//password checker (Java Edition!)
import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;
//C:\Users\bvo10\OneDrive\Desktop\passwords.txt
//this program reads from a file of passwords and finds the total number of passwords that matches all the criteria
public class PasswordChecker {

	public static void main(String[] args) {
		System.out.println("Welcome to Password Checker!"); 
		System.out.println(); 
		String fileName = "";
		int validPasswords = 0; //running total to see how many passwords are valid in the file
		if (args.length == 1){
			fileName = args[0];
		}
		else {
			System.out.print("Please enter file name with passwords: ");
			Scanner s = new Scanner(System.in);
			fileName = s.nextLine();
		}
		try{
			Scanner f = new Scanner (new File(fileName));
			while (f.hasNextLine()){
				String passwords = f.nextLine();
				if (lengthChecker(passwords) && spaceChecker(passwords) && uppercaseLetterChecker(passwords)&& lowercaseLetterChecker(passwords)
						&& digitChecker(passwords) && specialCharacterChecker(passwords)) {
					validPasswords++; //keep track of valid passwords
					System.out.println(passwords);
				}
				
				

				
			}
			System.out.println("There are " + validPasswords + " valid passwords in the file " + fileName);
		}
		catch (FileNotFoundException e){
			System.out.println("File " + fileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}

}

	
	
	
	//validation function that checks for at least 12 characters 
	public static boolean lengthChecker (String theValue) {
		boolean flag = true; 
		if (theValue.length() < 12) {
			flag = false;
		}
		else {
			flag = true;
		}
		return flag;
	}
		
	
	
	//validation function that checks for no spaces
	public static boolean spaceChecker (String theValue) {
		boolean flag = true;
		for (int i = 0 ; i < theValue.length(); i++) {
			if (Character.isWhitespace(theValue.charAt(i))) {
				flag = false;
				break;
			}
			else {
				flag = true;
			}
		}
		return flag;
	}
	
	
	//validation function to check for at least one upper-case letter
	public static boolean uppercaseLetterChecker (String theValue) {
		boolean flag = false;
		for (int i = 0; i < theValue.length(); i++) {
			if (Character.isUpperCase(theValue.charAt(i)) && Character.isLetter(theValue.charAt(i))) {
				flag = true;
				break;
			}
			else {
				flag = false; 
			}
		}
		return flag;
	}
	
	//validation function to check for at least one lower case letter 
	public static boolean lowercaseLetterChecker (String theValue) {
		boolean flag = false;
		for (int i = 0; i < theValue.length(); i++) {
			if (Character.isLowerCase(theValue.charAt(i)) && Character.isLetter(theValue.charAt(i))) {
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	
	//validation function to check for at least one digit 
	public static boolean digitChecker (String theValue) {
		boolean flag = false; 
		for (int i = 0; i < theValue.length(); i++) {
			if (Character.isDigit(theValue.charAt(i))) {
			flag = true;
			break;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	
	
	
	//validation function to check for at least one special character 
	public static boolean specialCharacterChecker (String theValue) {
		boolean flag = false; 
		for (int i = 0 ; i < theValue.length(); i++) {
			if (!Character.isDigit(theValue.charAt(i)) && !Character.isLetter(theValue.charAt(i)) && !Character.isWhitespace(theValue.charAt(i))) {
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		return flag;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
