// alan vo 
// occc fall 2022
// beginning programming 
// worked with Steve at the Computer center 
// prime number list

#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;

bool isPrime(int); // prototype function to determine whether a number is prime or not

int main() {
	int minNumber; // to store minimum number entered by user
	int maxNumber; // to store maximum number entered by user
	string fileName; // to store the file name entered by user
	cout << "Please enter a minimum number: ";
	cin >> minNumber;
	cout << endl;
	cout << "Please enter a maximum number: ";
	cin >> maxNumber;
	cout << endl;
	int tempNumber; // used to allow for the input to still be ordered from lowest to highest value, no matter the order the user inputs
	if (minNumber > maxNumber) {
		tempNumber = maxNumber; // to store the original value of the maximum number variable
		maxNumber = minNumber; 
		minNumber = tempNumber; 
	}
	cout << "Enter a file name for where you want the prime numbers to be placed: ";
	cin.ignore(); // ignore the new line character
	getline(cin, fileName);
	ofstream outputFile; // defining an output file object 
	outputFile.open(fileName); // opening the file that was inputted by the user

	for (int i = minNumber; i <= maxNumber; i++) {
		if (isPrime(i)) {
			cout << i << endl; 
			outputFile << i << endl; // writing to the file 
		}
	}
	outputFile.close(); // always close the file after done 
	return 0;
}


bool isPrime(int p) {
	bool result = true; // set the result to true first 
	if (p >= 2) {
		int stop = (int)sqrt(p);

		for (int d = 2; d <= stop; d++) {  
			if (p % d == 0) { // if a number is divided by 2 and has no remainder it is an even number
				result = false;
				break;
			}
		}
	}
	else {
		result = false;
	}
	return result;
}
