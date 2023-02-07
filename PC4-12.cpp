// alan vo 
// occc fall 2022 
// beginning programming 
// software sales 

#include <iostream>
#include <iomanip>
using namespace std; 

int main() {
	const double RETAIL = 99.00; // constant to store the retail price for one software package
	int quantity; // variable to store the quantity(s) sold
	double regular; // variable to store regular price without discount 
	double discount; // variable to store the discount
	double total; // variable to store the total price after any possible discounts
	
	cout << "Welcome! Please enter the quantity of software sales that you would like to purchase: ";
	cin >> quantity;

		if (quantity >= 1 && quantity <= 9) {
			regular = quantity * RETAIL;
			discount = 0;
			total = regular - discount;
			cout << "There is no discount";
		}
		else if (quantity >= 10 && quantity <= 19) {
			regular = quantity * RETAIL;
			discount = regular * 0.2;
			total = regular - discount;
			cout << "Your discount is 20 percent";
		}
		else if (quantity >= 20 && quantity <= 49) {
			regular = quantity * RETAIL;
			discount = regular * 0.3;
			total = regular - discount;
			cout << "Your discount is 30 percent";
		}
		else if (quantity >= 50 && quantity <= 99) {
			regular = quantity * RETAIL;
			discount = regular * 0.4;
			total = regular - discount;
			cout << "Your discount is 40 percent";
		}
		else if (quantity >= 100) {
			regular = quantity * RETAIL;
			discount = regular * 0.5;
			total = regular - discount;
			cout << "Your discount is 50 percent";
		}
		else {
			cout << "ERROR, please enter a valid quantity that is greater than 0." << endl;
		}

	cout << endl;
	cout << "-----------------------------" << endl;
	cout << showpoint << fixed << setprecision(2); // 2 decimal points
	cout << "Regular Price: " << setw(14) << regular << endl;
	cout << "Discount: " << setw(19) << discount << endl;
	cout << "Total Price: " << setw(16)<< total << endl;
	return 0; 
}