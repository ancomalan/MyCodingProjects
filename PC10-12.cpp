// alan vo 
// occc fall 2022
// beginning programming 
// password checker

#include <iostream>
#include <cctype>
#include <string>
using namespace std; 

bool testStringLength(const string&); // function prototype to test the string length 
bool testSpaces(const string&); // function prototype to test for spaces in the password
bool testLower(const string&); // function prototype to test for at least one lower case letter
bool testUpper(const string&); // function prototype to test for at least one upper case letter
bool testDigit(const string&); // function prototype to test that the password contains at least one digit 
bool testSpecial(const string&); // function prototype to test that the password contains a special character

int main() {
	string password; // to store password inputted by the user
	cout << "Please enter a password with at least 12 characters, no spaces, one uppercase letter, one lowercase letter, one digit, and one special character: " << endl;
	getline(cin, password);

	while (!testStringLength(password) || !testSpaces(password) || !testLower(password) || !testUpper(password) || !testDigit(password) || !testSpecial(password)) {
		if (!testStringLength(password)) {
			cout << "Please enter at least 12 characters. " << endl;
		}
		if (!testSpaces(password)) {
			cout << "No spaces are allowed. " << endl;
		}
		if (!testLower(password)) {
			cout << "There must be at least 1 lowercase letter. " << endl;
		}
		if (!testUpper(password)) {
			cout << "There must be at least 1 uppercase letter. " << endl;
		}
		if (!testDigit(password)) {
			cout << "There must be at least one digit. " << endl;
		}
		if (!testSpecial(password)) {
			cout << "There must be at least one special character. " << endl;
		}
		cout << "Try again: " << endl;
		getline(cin, password);
	}
	cout << "Valid Password." << endl;
	return 0;
}

bool testSpecial(const string& password) {
	for (int x = 0; x < password.length(); x++) {
		if (ispunct(password[x]) && !isspace(password[x]) && !isalnum(password[x])) {
			return true;
		}
	}
	return false;
}

bool testDigit(const string &password) {
	for (int x = 0; x < password.length(); x++) {
		if (isdigit(password[x])) {
			return true;
		}
	}
	return false;
}

bool testUpper(const string& password) {
	for (int x = 0; x < password.length(); x++) {
		if (isupper(password[x])) {
			return true; 
		}
	}
	return false;
}

bool testLower(const string &password) {
	for (int x = 0; x < password.length(); x++) {
		if (islower(password[x])) {
			return true;
		}
	}
	return false;
}

bool testSpaces(const string &password) {
	
	for (int x = 0; x < password.length(); x++) {
		if (isspace(password[x])) { // if the password contains any spaces, return false
			return false;
		}
	}
	return true;
}

bool testStringLength(const string &password) {
	if (password.length() < 12) {
		return false;
	}
	else {
		return true;
	}

}