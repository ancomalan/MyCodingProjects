//alan vo 
//occc fall 2023
//advanced java
//palindromes 
import java.util.Scanner;
public class Palindromes {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String inputString = "";
		System.out.println("Welcome to the Palindromes Program!");
		//prompt for input string
		System.out.print("Please enter a string: ");
		inputString = input.nextLine();

		//if is palindrome, specify result as ordinary (spaces ignored) or strict (spaces considered)
		if (isOrdinaryPalindrome(inputString)) {
			//check for strict palindromes
			if (isStrictPalindrome(inputString)) {
				System.out.println(inputString + " is a strict palindrome!");
			}
			else {
				System.out.println(inputString + " is an ordinary palindrome!");
			}
		}	
		else {
			System.out.println(inputString + " is NOT a palindrome!");
		}
		input.close();
	}
	//recursive function to check first if string is an ordinary palindrome (no spaces)
	//I received some help from https://stackoverflow.com/questions/4367260/creating-a-recursive-method-for-palindrome 
	public static boolean isOrdinaryPalindrome (String input) {
		//base cases 
		if (input.length() == 0 || input.length() == 1) {
			return true;
		}
		String upperCaseString = input.toUpperCase(); //change string to upper-case so that it is not case sensitive

		//strip out punctuation, special characters, and spaces
		String possiblePalindrome = upperCaseString.replaceAll("[^a-zA-Z0-9]", ""); //I learned how to strip special characters from https://javarevisited.blogspot.com/2016/02/how-to-remove-all-special-characters-of-String-in-java.html#:~:text=Similarly%2C%20if%20you%20String%20contains,to%209%2C_%20and%20dash.

		if(possiblePalindrome.charAt(0) == possiblePalindrome.charAt(possiblePalindrome.length()-1)) {
			/* check first and last character of String: if they are same, repeat for substring with the first and last character removed.
			repeat until string removes all characters or characters do not match */
			return isOrdinaryPalindrome(possiblePalindrome.substring(1, possiblePalindrome.length()-1));
		}

		// If program reaches this statement, it means the String is not palindrome so return false.
		return false;
	}

	//recursive function to check for strict palindrome (spaces considered)
	public static boolean isStrictPalindrome (String input) {
		//base cases 
		if (input.length() == 0 || input.length() == 1) {
			return true;

		}

		String upperCaseString = input.toUpperCase();
		//strip out punctuation, special characters, but do not strip spaces
		String possibleStrictPalindrome = upperCaseString.replaceAll("[^a-zA-Z0-9 ]", "");


		if(possibleStrictPalindrome.charAt(0) == possibleStrictPalindrome.charAt(possibleStrictPalindrome.length()-1)) {
			/* check first and last character of String: if they are same, repeat for substring with the first and last character removed.
			repeat until string removes all characters or characters do not match */
			return isStrictPalindrome(possibleStrictPalindrome.substring(1, possibleStrictPalindrome.length()-1));
		}

		// If program reaches this statement, it means the String is not a strict palindrome so return false.
		return false;
	}
}

