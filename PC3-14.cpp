// alan vo 
// occc fall 2022 
// beginning programming 
// monthly sales tax 

#include <iostream>
#include <iomanip> 
#include <string>
using namespace std; 

int main() {

	const double STATE_TAX_RATE = 0.04; // state sales tax 
	const double COUNTY_TAX_RATE = 0.02; // county sales tax 
	double sales, county_sales_tax, state_sales_tax, total, total_sales_tax; 
	string month, year;

	cout << "Please enter the month: ";
	getline(cin, month);
	cout << "Please enter the year: ";
	getline(cin, year);
	cout << "Please enter the total amount collected at the cash register: ";
	cin >> total; //total of product sales and sales taxes
	sales = total / 1.06; // calculation for the amount of product sales
	county_sales_tax = sales * COUNTY_TAX_RATE; // calculation of county sales tax 
	state_sales_tax = sales * STATE_TAX_RATE; //calculation of state sales tax 
	total_sales_tax = county_sales_tax + state_sales_tax; //calculation of total sales tax
	
	cout << "Month: " << month << endl;
	cout << "Year: " << year << endl; 
	cout << "----------------\n";
	cout << setprecision(2) << fixed; //show exactly 2 digits after decimal point
	cout << "Total collected: " << setw(8) << total << endl; //display total amount of money from sales and sales tax
	cout << "Sales: " << setw(18) << sales << endl; //display product sales
	cout << "County sales tax: " << setw(7) << county_sales_tax << endl; //display county sales tax 
	cout << "State sales tax: " << setw(8) << state_sales_tax << endl; //display state sales tax 
	cout << "Total sales tax: " << setw(8) << total_sales_tax << endl; //display total sales tax 
	return 0; 

}