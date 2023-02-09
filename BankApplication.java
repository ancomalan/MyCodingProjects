/**
* Name: Alan Vo 
* Date: 02/08/23
* File: BankApplication.java
* Description: This program uses the CheckingAccount class to create a bank application with a menu, which can perform different tasks based on the user's input.  
*/
import java.util.Scanner;
public class BankApplication {

	public static void main(String[] args) {
		// create an object 
		CheckingAccount myAccount = new CheckingAccount();


		// create date object to store the time the account was created
		java.util.Date date = new java.util.Date();
		myAccount.dateCreated = date;


		// create a scanner object to read input from keyboard
		Scanner input = new Scanner(System.in);
		System.out.println("MidFirst Banking Application");


		// obtain unique ID from user
		System.out.print("Enter the unique ID: ");
		String uniqueID = input.nextLine();
		// input validation for the unique ID 
		while (uniqueID.length() < 4) {
			System.out.print("Invalid unique ID. There needs to be at least 4 characters. Please try again: ");
			uniqueID = input.nextLine();
		}
		myAccount.setUniqueID(uniqueID); // use setter method to set the unique ID to the myAccount object 


		// obtain account balance from user
		System.out.print("Enter the intial account balance: $");
		double initialAccountBalance = input.nextDouble();
		// input validation for the account balance 
		while (initialAccountBalance < 500.0) {
			System.out.print("Invalid account balance. There needs to be at least $500. Please try again: ");
			initialAccountBalance = input.nextDouble();
		}
		myAccount.setAcctBalance(initialAccountBalance); // use setter method to set the initial account balance to myAccount object


		// obtain annual interest rate from user 
		System.out.print("Enter annual interest rate as a percentage: ");
		double annualInterestRate = input.nextDouble();
		myAccount.setAnnualInterestRate(annualInterestRate); // use setter method to set the annual interest rate to myAccount object
		System.out.println();


		// Use a do-while loop to display list of options to deposit, check daily interest, check account details, and exit the program.
		char continueLoop = 'Y';
		do {
			System.out.println("===============================");
			System.out.println("      =    Options    =     ");
			System.out.println("===============================");
			System.out.println("1. Deposit");
			System.out.println("2. View Daily Interest Rate");
			System.out.println("3. View Account Details");
			System.out.println("4. Exit");
			System.out.print("Please enter your selection: ");
			int userSelection = input.nextInt();


			// input validation for the user selection 
			while (userSelection < 0 || userSelection > 4) {
				System.out.print("Invalid selection. Please try once more: ");
				userSelection = input.nextInt();
			}


			// use switch statements to determine the user's choice and act accordingly
			switch (userSelection) {
			case 1: System.out.print("Enter your deposit amount: ");
			double depositAmount = input.nextDouble();
			// input validation for the deposit amount 
			while (depositAmount <= 0) {
				System.out.print("Invalid. Deposit amount can not be less than or equal to zero. Please try again: ");
				depositAmount = input.nextDouble();
			}
			System.out.printf("Your new balance is: $%4.2f", myAccount.depositCash(depositAmount));
			System.out.println();
			System.out.println();
			break;

			case 2: System.out.println("Your daily interest rate is: $" + myAccount.getDailyIntRate());
			System.out.println();
			break;	

			case 3: System.out.println("Account Unique ID: " + myAccount.getUniqueID());
			System.out.println("Account Creation Date/Time: " + myAccount.dateCreated);
			System.out.printf("Balance: $%4.2f", myAccount.getAcctBalance());
			System.out.println();
			System.out.println("Daily Interest Amount: $" + myAccount.getDailyIntRate());
			System.out.println();
			break;

			case 4: continueLoop = 'N'; 
			System.out.println("Program exiting...");
			break;
			}
		} while (continueLoop == 'Y');
		input.close(); // close the scanner 
	}
}


