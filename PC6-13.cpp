// alan vo 
// occc fall 2022 
// beginning programming 
// days out homework

#include <iostream>
#include <iomanip>
using namespace std; 


int getEmployeeNumber(); // prototype function to get number of employees in company
bool isValidEmployees(int); // prototype function for input validation regarding the number of employees entered by the user
int daysMissed(int); // prototype function that returns the total number of days missed
bool isValidDaysMissed(int); // prototype function for input validation regarding the number of days missed
double averageDaysMissed(double, double); // prototype function to return the average number of days missed by the employees

int main() {
	int a; // variable to store the amount of employees entered by the user
	int b; // variable to store the total amount of days missed by the employees
	double c; // variable to store the average amount of days missed by employees
	a = getEmployeeNumber(); // calling the function and returning the number of employees inputted to the variable a
	b = daysMissed(a); // calling the function to find the total number of days missed 
	c = averageDaysMissed(a, b); // calculating the average days missed 
	cout << fixed << showpoint << setprecision(2) << c << " days missed on average!";

	return 0;
}

double averageDaysMissed(double a, double b) {
	return b / a; // returning the average number of days missed 
}


int daysMissed(int x) {
	int daysMissed; // to store the days missed per employee
	int totalDaysMissed = 0; // accumulator to store the total days missed 
	for (int count = 1; count <= x; count++) {
		cout << "Please enter the amount of days employee " << count << " missed: ";
		cin >> daysMissed; 
		while (!isValidDaysMissed(daysMissed)) {
			cout << "Error! Please enter a positive number: ";
			cin >> daysMissed; 
		}
		totalDaysMissed += daysMissed;
	}
	return totalDaysMissed; // return the total amount of days missed
}

int getEmployeeNumber() {
	int number;
	cout << "Please enter the amount of employees in the company: ";
	cin >> number; 
	while (!isValidEmployees(number)) {
		cout << "Error! Please enter a number greater than 1: ";
		cin >> number;
	}
	return number;
}

bool isValidEmployees(int a) {
	return (a > 1);
}

bool isValidDaysMissed(int b) {
	return (b >= 0);
}