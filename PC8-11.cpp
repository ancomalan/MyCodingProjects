// alan vo 
// occc fall 2022 
// beginning programming 
// selection sort 


#include <iostream>
#include <string>
#include <fstream>
using namespace std;

void selectionSort(string[], int); // prototype function to sort the string array in alphabetical order
void swap(string &, string &); // prototype function to swap string values

int main() {
	const int NUM_NAMES = 50; // global constant for the size of the array
	string names[NUM_NAMES]; // array definition
	string fileName; // variable to hold file name inputted by the user

	cout << "Please enter a file name: "; 
	getline(cin, fileName); // get the file name
	ifstream inputFile; // input file object
	inputFile.open(fileName); // opening the file 

	if (inputFile.is_open()) {
		//display the names before sorting
		cout << "Unsorted Names: " << endl;
		for (int index = 0; index < 50; index++) {
			getline(inputFile, names[index]); // read the names into the array
			cout << names[index] << endl;
		}
		cout << endl;
		// display the names after sorting alphabetically
		cout << "Sorted Names: " << endl;
		selectionSort(names, NUM_NAMES); // calling the function to sort the array in alphabetical order
		for (int index = 0; index < 50; index++) {
			cout << names[index] << endl;
		}
	}
	else {
		cout << "Error opening the files.";
	}
	inputFile.close(); // close the file after done

	return 0;
}

void selectionSort(string names[], int size) {
	int minIndex;
	string minValue; // because the value of a string is not an int
	for (int start = 0; start < (size - 1); start++) {
		   minIndex = start; // subscript
		   minValue = names[start]; // value of array element

		   for (int index = start + 1; index < size; index++) // for the element right after, check its value...
			   {
					 if (names[index] < minValue)
						  {
							minValue = names[index]; 
							minIndex = index;
						 }
				  }
		  swap(names[minIndex], names[start]);
	 }
}

void swap(string &a, string &b) {
	string temp = a; 
	a = b;
	b = temp;
}
