/**
* Name: Alan Vo 
* Date: 01/18/23
* File: StockSelector.java
* Description: This program accepts user input of various stock criteria, then calculates the number of shares able to be purchased, and finally displays information to the user about the stock that they inputed. 
*/

// importing Scanner class, to receive input from the user
import java.util.Scanner;

public class StockSelector {
	public static void main(String[] args) {
		System.out.println("Welcome to the Stock Selector App!\n"); //greet the user
		
		//create scanner object for console input 
		Scanner input = new Scanner(System.in);
				
		
		//prompt user for amount of money they are willing to invest 
		System.out.print("Please enter amount of money that you are willing to invest: $");
		double investmentMoney = input.nextDouble(); 
		input.nextLine(); // used to skip over the end of line character so that it does not get read for the next user input 
		
		
		//prompt user for stock ticker initials
		System.out.print("Please enter stock ticker: ");
		String stockTicker = input.nextLine();
		
		
		//input validation for stock ticker initials
		if (stockTicker.length()> 5) {
			System.out.println("Invalid (stock ticker can not be more than 5 characters long). Try again. ");
			System.out.print("Please enter stock ticker: ");
			stockTicker = input.nextLine();
		}
		
		
		//prompt user for stock price
		System.out.print("Please enter stock price: $");
		double stockPrice = input.nextDouble();

		
		//input validation for stock price 
		if (stockPrice < 5.00) {
			System.out.println("Invalid (stock price has to be at least $5.00). Try again. " );
			System.out.print("Please enter stock price: $");
			stockPrice = input.nextDouble();
		}
	
		
		//prompt user for price-to-earnings ratio 
		System.out.print("Please enter price-to-earnings (P/E) ratio: ");
		double priceToEarningRatio = input.nextDouble();
		System.out.println();
		
		
		//calculate the number of shares able to be purchased
		double numberOfShares = Math.round(investmentMoney / stockPrice);
		int numberOfSharesInteger = (int) numberOfShares; // change the decimal to integer for output without the decimal point 
		
		
		//display results to user
		System.out.println("Below are your results: \n");
		System.out.println("Stock: " + stockTicker);
		System.out.println("Price: $" + stockPrice);
		System.out.println("P/E (Price-to-Earnings) Ratio: " + priceToEarningRatio);
		//print out warning message if price-to-earnings ratio is over 75
		if (priceToEarningRatio > 75.0) {
			System.out.println("This stock may be overvalued. Proceed with caution!");
		}
		System.out.println("Number of shares able to be purchased: " + numberOfSharesInteger);
	}
}
