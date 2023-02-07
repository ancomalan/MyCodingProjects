// alan vo 
// occc fall 2022
// beginning programming 
// backwards string

#include <iostream>
#include <string>
using namespace std; 

string reverseString(const string&); // function prototype

int main() {
	string value; // value to store string inputted by the user 
	string reverse; // variable to store the reverse string 
	cout << "Please enter a string that you would like reversed: "; 
	getline(cin, value);
	reverse = reverseString(value); // calling the reverse function
	cout << reverse << endl;

	return 0;
}
string reverseString(const string &value) {
	string reverse; 
	// for loop to print each character of the string backwards, from the biggest subscript to 0
	for (int x = value.length()-1; x >= 0; x--) {
		reverse += value[x];
	}
	return reverse; 

}
