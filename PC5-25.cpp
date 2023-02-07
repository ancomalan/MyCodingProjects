// alan vo 
// occc fall 2022 
// beginning programming
// student line up from file homework
// I had trouble on how to figure out who was the first and last in line from the file lines (24-43), so I found help online from a YouTuber named "Jesus Hilario H" 
// source: https://jesushilarioh.com/chapter-5-25-using-files-student-line-up-tony-gaddis-starting-out-with-c-plus-plus/
// I also figured out where to insert the getline function with some help from my father

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {

	cout << "Welcome to file input!" << endl;
	string fileName; 
	cout << "Please enter file name: ";
	getline(cin, fileName); // get the file name 

	ifstream inputFile;
	inputFile.open(fileName); // open the file 

	string fullName; // to store the first, full name from the file (Lastname, Firstname)
	string firstStudent;// to store the first, full (last and first) name in alphabet
	string lastStudent; // to store the last full name in alphabet


	if (inputFile.is_open()) {
		getline(inputFile, fullName); // read the first line (including spaces) from the file
		firstStudent = fullName; // assign first full name read from the file to variable
		lastStudent = fullName; // also assign first full name read from the file to this variable
		// these variables will be used to compare to the other strings during the while loop below

		while (getline(inputFile, fullName)) { // while input file continues to read names into the students variable...
			if (fullName < firstStudent) { // compare the value of the first full name read from the file with the new name read during the loop
				firstStudent = fullName;
			}
			if (fullName > lastStudent){
						lastStudent = fullName;
			}
		}
		inputFile.close(); // close the file after done
	}
	else {
		cout << "There was an error opening the file: " << fileName << ". " << "Please try again." << endl;
	}
	
	cout << "The first student in line is: " << firstStudent << endl;
	cout << "The last student in line is: " << lastStudent << endl;
	return 0; 
}