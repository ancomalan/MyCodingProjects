//alan vo 
//ou spring 2024
//data structures 
//unordered maps

#include <iostream>
#include <string>
#include <vector>
#include <fstream> //for files
#include <unordered_map>
using namespace std;

//student names file: C:\Users\bvo10\Downloads\Names.txt
//assignments file: C:\Users\bvo10\Downloads\Assignments.txt

/*
You will prompt for a names file and store all the students names into a vector of string objects.
You then will read in a file with the assignment submissions, and determine if this file has already
been tallied, if it has not been then tally into the amount of assignments tallied for a student.
This will require a few unordered_map objects (I will not tell you what the key and value types
will be, you’ll need to figure that out
*/

int main() {
	string studentFileName, assignmentsFileName; //variables for file names
	ifstream inputFileStudents, inputFileAssignments;//input file objects to read from files
	vector<string> studentNames;//create a vector of string objects to store all student names

	//while input file has not been opened, keep asking the user for file name
	while (!inputFileStudents.is_open()) {
		cout << "Please enter file with student names: ";
		cin >> studentFileName;
		inputFileStudents.open(studentFileName);//try to open the file
	}

	//while input file still has more elements, store all the student names into the vector
	string names; //variable to store all the student names
	while (getline(inputFileStudents, names)) {
		studentNames.push_back(names);
	}

	//now that we have student names in vector, read in file with assignment submissions
	//while assignments file is not open, keep prompting user for assignment file
	while (!inputFileAssignments.is_open()) {
		cout << "Please enter assignments file: ";
		cin >> assignmentsFileName;
		inputFileAssignments.open(assignmentsFileName);
	}
	cout << endl;

	//create a hashmap to tally the number of missing assignments 
	//key is name of students (string)
	//value is a hashmap with key (assignment number) and value (boolean)
	//first locate the students name, then look for if they completed a certain assignment number. If they have, mark boolean as true 
	unordered_map<string, unordered_map<int, bool>> tally;
	string fullAssignment; //represents each line in the file in the format: studentName_A#
	string assignmentName; //name of student 
	int assignmentNumber;

	//use substrings to seperate name and assignment number
	//use find to locate the underscore and everything to the left is the name and everything to the right is the assignment number
	while (getline(inputFileAssignments, fullAssignment)) {
		int positionOfUnderscore = fullAssignment.find("_");
		assignmentName = fullAssignment.substr(0, positionOfUnderscore); //student name starts at index 0 and stops at position of underscore
		assignmentNumber = stoi(fullAssignment.substr(positionOfUnderscore + 2));//assignment number is 2 positions after underscore. stoi converts string into int

		//tally into the hashmap if not already 
		if (!tally[assignmentName][assignmentNumber]) {
			tally[assignmentName][assignmentNumber] = true; //assign the value of the key to true to account for the assignment
		}
	}

	//print out information to user
	cout << "Student Name\tMissing Assignments" << endl;
	//loop through unordered map using vector
	for (const string& names : studentNames) {
		int numberOfAssignmentsCompleted = tally[names].size(); /* # of assignments tallied for each student is # number of unique keys (assignment #'s) in the inner map corresponding to that student*/
		int numberOfMissingAssignments = 9 - numberOfAssignmentsCompleted; //subtract number of assignments tallied for each student from 9 to find how much assignments each missed

		if (names == "Annamaria" || names == "Chantalle" || names == "Sebastien") {
			cout << names << "\t" << numberOfMissingAssignments << endl;
		}
		else {
			cout << names << "\t\t" << numberOfMissingAssignments << endl;
		}
	}
}

