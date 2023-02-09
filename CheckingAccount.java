/**
* Name: Alan Vo 
* Date: 02/08/23
* File: CheckingAccount.java
* Description: This program consists of all the data variables, constructors, getters, setters, and methods to be used in the Bank Application program.
*/

import java.util.Date; //importing the date class to create the date data variable
public class CheckingAccount {
	//create a list of private data members
	private String uniqueID; 
	private double acctBalance; 
	private double annualInterestRate; 
	public Date dateCreated; 


	//create a default constructor 
	public CheckingAccount(){

	}
	
	//create a constructor that accepts the uniqueID and acctBalance
	public CheckingAccount(String uniqueID, double acctBalance) {
		this.uniqueID = uniqueID; 
		this.acctBalance = acctBalance; 
	}


	//getters
	public String getUniqueID() {
		return uniqueID;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	
	//setters
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}


	// create a toString method to print the contents of the object 
	@Override
	public String toString() {
		return "CheckingAccount [uniqueID=" + uniqueID + ", acctBalance=" + acctBalance + ", annualInterestRate="
				+ annualInterestRate + ", dateCreated=" + dateCreated + "]";
	}


	// create a method that deposits specified amount of money to the account 
	public double depositCash(double cash) {
		return acctBalance += cash;
	}
	
	// create another method that returns the daily interest rate
	public double getDailyIntRate() {
		double dailyIntRate = ((annualInterestRate / 100) * acctBalance / 365); 
		dailyIntRate = Math.round(dailyIntRate * 100.0) / 100.0;
		return dailyIntRate;
	}



}
