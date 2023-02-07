// alan vo 
// occc fall 2022
// beginning programming 
// star search

#include <iostream>
#include <iomanip>
using namespace std;

double findHighest(double, double, double, double, double); // new prototype for function that finds highest number
double findLowest(double, double, double, double, double); // prototype for function that finds lowest number
bool isValid(double); // prototype for validation function 
void getJudgeData(double&); // prototype for getScore function without a return type 
double calcScore(double, double, double, double, double); // function prototype for calcAverage 


const double MIN_VALUE = 0; // global constant for input validation regarding the minimum judge score allowed
const double MAX_VALUE = 10;  // global constant for input validation regarding the maximum judge score allowed


int main() {

	double score1, score2, score3, score4, score5;

	getJudgeData(score1);
	getJudgeData(score2);
	getJudgeData(score3);
	getJudgeData(score4);
	getJudgeData(score5);

	calcScore(score1, score2, score3, score4, score5);

	return 0;
}

// function definition for calculating the average of the scores 
double calcScore(double a, double b, double c, double d, double e) {
	double theAverage; // to store the final score after dropping the lowest number and highest number
	theAverage = ((a + b + c + d + e) - findLowest(a, b, c, d, e) - findHighest(a,b,c,d,e)) / 3;
	cout << fixed << showpoint << setprecision(2); // 2 decimal points
	cout << "The final score is: " << theAverage << "!" << endl;
	return theAverage;
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

// function definition for findLowest
double findLowest(double a, double b, double c, double d, double e) {
	double theLowest = a; // local variable used to compare with the other values
	if (b < theLowest) {
		theLowest = b;
	}
	if (c < theLowest) {
		theLowest = c;
	}
	if (d < theLowest) {
		theLowest = d;
	}
	if (e < theLowest) {
		theLowest = e;
	}
	return theLowest; // return the lowest 
}

// new function definition for findHighest 
double findHighest(double a, double b, double c, double d, double e) {
	double theHighest = a; // local variable used to compare with the others
	if (b > theHighest) {
		theHighest = b;
	}
	if (c > theHighest) {
		theHighest = c;
	}
	if (d > theHighest) {
		theHighest = d; 
	}
	if (e > theHighest) {
		theHighest = e;
	}
	return theHighest; // return the highest number
}


// function definition for input validation
bool isValid(double x) {
	return (x >= MIN_VALUE && x <= MAX_VALUE); // returns true if within this range 
}