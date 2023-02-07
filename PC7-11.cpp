// alan vo 
// occc fall 2022
// beginning programming 
// exam grader
// I gained inspiration on how to structure the comparison part of the arrays (lines 35-40) with this source: https://github.com/VeeShostak/Cpp11-FromControlStructuresToObjects8thEd-byTonyGaddis/blob/master/c7%2011.%20Exam%20Grader/11.%20Exam%20Grader.cpp

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

int main() {
	const int SIZE = 20; // constant size of arrays
	char correctAnswers[SIZE]; // first array for the correct answers from the file
	char studentAnswers[SIZE]; // second array for the student's answers from the file
	string fileName1; // for the correct answer file
	string fileName2; // for the student answer file

	cout << "Hello! Welcome to Exam Grader!" << endl;
	cout << "Please enter a file name that contains the correct answers: ";
	getline(cin, fileName1); // get the file name for the correct answers
	cout << "Please enter a file name that contains the student's answers: ";
	getline(cin, fileName2); // get the file name for the student's answers
	cout << endl;
	
	ifstream correctFile; // creating an input file object named correctFile 
	ifstream studentFile; // creating an input file object named studentFile
	correctFile.open(fileName1); // open the correct answer file
	studentFile.open(fileName2); // open the student answer file
	double questionsMissed = 0; // accumulator to store the total number of questions missed
	
	// testing whether the arrays are open and comparing the arrays
	if (correctFile.is_open() && studentFile.is_open()) {
		// read the values from the files into both the arrays
		for (int index = 0; index < SIZE; index++) {
			correctFile >> correctAnswers[index];
			studentFile >> studentAnswers[index];
			if (correctAnswers[index] != studentAnswers[index]) {
				cout << "Question " << index + 1 << " is incorrect." << endl;
				cout << "The student answered: " << setw(3) << studentAnswers[index] << endl;
				cout << "The correct answer was: " << correctAnswers[index] << endl;
				cout << endl;
				questionsMissed++; // storing the total number of questions missed 
			}
		}
		cout << "Total Questions Missed: " << questionsMissed << endl; // display the total number of questions missed
		double questionsCorrect; // variable to store the number of questions correct 
		questionsCorrect = SIZE - questionsMissed;

		double percentageCorrect; // variable to store the percentage of correct questions answered
		percentageCorrect = (questionsCorrect / SIZE) * 100;
		cout << "Percentage of Questions Answered Correctly: " << fixed << showpoint << setprecision(2) << percentageCorrect << "%" << endl;
		
		if (percentageCorrect >= 70) {
			cout << "Congratulations! You have passed your exam." << endl;
		}
		else {
			cout << "You have failed your exam, better luck next time." << endl;
		}
		// closing the files after done
		correctFile.close();
		studentFile.close(); 
	}
	else {
		cout << "Error opening the files."; 
	}

	return 0;
}


