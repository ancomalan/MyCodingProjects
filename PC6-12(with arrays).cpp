// alan vo 
// occc fall 2022
// beginning programming 
// star search with arrays

#include <iostream>
#include <iomanip>
using namespace std;

double findHighest(const double [], int); // prototype for function that finds highest number
double findLowest(const double [], int); // prototype for function that finds lowest number
double calcScore(const double [], int); // function prototype that calculates the average score once the highest and lowest are dropped 
bool isValid(double); // prototype for validation function 
void getJudgeData(double&); // prototype for function that gets the scores without a return type 


const double MIN_VALUE = 0; // global constant for input validation regarding the minimum judge score allowed
const double MAX_VALUE = 10;  // global constant for input validation regarding the maximum judge score allowed

int main() {
	const int numScores = 5; // declaring a constant integer for the size of the array
	double theScores[numScores]; // array definition
	for (int index = 0; index < numScores; index++) {
		getJudgeData(theScores[index]); // get the 5 scores by calling the function, which stores each value entered, in an element of the array
	}
	calcScore(theScores, numScores); // calculating the average score with the highest and lowest scores dropped

	return 0;
}

// function definition for calculating the average of the scores, with the higest and lowest scores dropped
double calcScore(const double numbers[], int size) {
	double total = 0; // accumulator
	for (int index = 0; index < size; index++) {
		total += numbers[index];
	}
	double theAverage; // to store the final score after dropping the lowest number and highest number
	theAverage = ((total - findLowest(numbers, size) - findHighest(numbers, size)) / (size - 2.0));
	cout << fixed << showpoint << setprecision(2); // 2 decimal points
	cout << "The final score is: " << theAverage << "!" << endl;
	return theAverage;
}


// function definition for findLowest
double findLowest(const double numbers[], int size) {
	double theLowest = numbers[0]; // local variable used to compare with the other values
	for (int index = 0; index < size; index++) {
		if (numbers[index] < theLowest) {
			theLowest = numbers[index];
		}
	}
	return theLowest; // return the lowest 
}

// new function definition for findHighest 
double findHighest(const double numbers[], int size) {
	double theHighest = numbers[0]; // local variable used to compare with the others
	for (int index = 0; index < size; index++) {
		if (numbers[index] > theHighest) {
			theHighest = numbers[index];
		}
	}
	return theHighest; // return the highest number
}

// function definition for input validation
bool isValid(double x) {
	return (x >= MIN_VALUE && x <= MAX_VALUE); // returns true if within this range 
}

// function definition for getting the score from the user
void getJudgeData(double& x) {
	cout << "Please enter a judge's score from " << MIN_VALUE << " to " << MAX_VALUE << ": ";
	cin >> x;
	while (!isValid(x)) // call the isValid function for input validation
	{
		cout << "INVALID! " << "PLEASE ENTER A SCORE FROM " << MIN_VALUE << " to " << MAX_VALUE << ": ";
		cin >> x;
	}

}