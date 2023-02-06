/**
* Name: Alan Vo 
* Date: 01/23/23
* File: AssignmentISBN.java
* Description: This program calculates the 13th checksum digit from a 12 digit ISBN number inputed by the user, keeps inventory of the number of books returned, checked out, and processed, and displays this information to the user
*/
import java.util.Scanner; 
public class AssignmentISBN {

	public static void main(String[] args) {
		char continueLoop = 'Y'; 
		String twelveDigits; // variable to hold the 12 digits inputed by the user
		Scanner input = new Scanner (System.in); // create a scanner object to read input 
		int returnCount = 0; // accumulator to store amount of books returned
		int checkoutCount = 0; // accumulator to store amount of books checked out 
		int processCount = 0 ; // accumulator to store amount of books processed 
		System.out.println("-==================================-");
		System.out.println("      Book Inventory Program");
		System.out.println("-==================================-");
		
		do {
			// obtain first 12 digits of ISBN-13 from user so that checksum can be calculated
			System.out.print("Please enter the first 12 digits of an ISBN-13 as a string: ");
			twelveDigits = input.nextLine();
			
			
			// loop for input validation to ensure user enters exactly 12 digits 
			while (twelveDigits.length() < 12 || twelveDigits.length() > 12) {
				System.out.println("Invalid ISBN-13 number (there needs to be 12 digits exactly). Please try again!");
				System.out.println();
				System.out.print("Please enter the first 12 digits of an ISBN-13 as a string: ");
				twelveDigits = input.nextLine();
			}
			
			
			// use a for loop to obtain numeric value of all 12 characters
			int checkSum = 0 ; // Initialize checksum to 0 because it is the accumulator 
			for (int count = 0 ; count <= 11 ; count++) {
				char digitCharacter = twelveDigits.charAt(count);
				int digit = Character.getNumericValue(digitCharacter);
				
				
				// calculate the checksum using formula from the book 
				if (count % 2 == 1) {
					checkSum += (3 * digit); // every odd index, the numeric value of the character at that index is multiplied by 3 and this product is added to the checksum
				}
				else {
					checkSum += digit; // every even index, the numeric value of the character is added to the checksum
				}
	
			}
			
			checkSum %= 10 ; // divide the sum of the numeric digit values by modulus 10 
			checkSum = 10 - checkSum ; // finally, subtract everything by 10 to obtain the checksum digit 
			
			
			// if the checksum is equal to 10, set it equal to 0 instead
			if (checkSum == 10) {
				checkSum = 0; 
			}
			
			
			// display final ISBN-13 number to the user
			String thirteenDigits = twelveDigits + checkSum; // append the checksum digit to the original 12 digits inputed by the user 
			System.out.println("ISBN-13 #: " + thirteenDigits);
			System.out.println();
			
			
			// prompt user if the book is for return or checkout 
			char bookReturn = 'R';
			char bookCheckout = 'C';
			System.out.print("Enter 'R' for book return or 'C' for book checkout: ");
			char userResponse = input.nextLine().charAt(0); // read the user's input 
			System.out.println();
			System.out.println("-==================================-");
			System.out.println("      Book Inventory Program");
			System.out.println("-==================================-");
			
			if (userResponse == 'R') {
				returnCount++; 
				processCount++;
			}
			else if (userResponse == 'C') {
				checkoutCount++; 
				processCount++;
			}
			
			
			// display the current book inventory information to the user
			System.out.printf("%10s%11d\n", "# books returned: ", returnCount);
			System.out.printf("%10s%8d\n", "# books checked out: ", checkoutCount);
			System.out.printf("%10s%10d\n", "# books processed: ", processCount);
			System.out.println("-==================================-");
			
			
			// prompt the user if they want the program to end or not
			System.out.print("Enter 'Y' to continue, 'N' to quit: "); 
			continueLoop = input.nextLine().charAt(0);
			System.out.println();
			
		} while (continueLoop == 'Y');
		
		
		// display final book inventory counts to user 
		System.out.println("-==================================-");
		System.out.println("      FINAL INVENTORY COUNTS");
		System.out.println("-==================================-");
		System.out.printf("%10s%11d\n", "# books returned: ", returnCount);
		System.out.printf("%10s%8d\n", "# books checked out: ", checkoutCount);
		System.out.printf("%10s%10d\n", "# books processed: ", processCount);
		System.out.println("-==================================-");	
		
	}		
}
