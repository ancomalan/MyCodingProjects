// alan vo 
// occc fall 2022
// beginning programming
// lowest score drop

#include <iostream>
#include <iomanip>
using namespace std;

double findLowest(double, double, double, double, double); // prototype for findLowest function
bool isValid(double); // prototype for validation function 
void getScore(double&); // prototype for getScore function without a return type 
double calcAverage(double, double, double, double, double); // function prototype for calcAverage 


const double MIN_VALUE = 0; // global constant for input validation regarding the minimum score 
const double MAX_VALUE = 100;  // global constant for input validation regarding the maximum score


int main() {

	double score1, score2, score3, score4, score5;

	getScore(score1);
	getScore(score2);
	getScore(score3);
	getScore(score4);
	getScore(score5);

	calcAverage(score1, score2, score3, score4, score5);

	return 0;
}

// function definition for calculating the average of the scores 
double calcAverage(double a, double b, double c, double d, double e) {
	double theAverage; // to store the total average after dropping the lowest number
	theAverage = ((a + b + c + d + e) - findLowest(a, b, c, d, e)) / 4;
	cout << fixed << showpoint << setprecision(2); // 2 decimal points
	cout << "The average of the test scores is: " << theAverage << "!" << endl;
	return theAverage;
}


// function definition for getting the score from the user
void getScore(double& x) {  
	cout << "Please enter a score from " << MIN_VALUE << " to " << MAX_VALUE << ": ";
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


// function definition for input validation
bool isValid(double x) { 
	return (x >= MIN_VALUE && x <= MAX_VALUE); // returns true if within this range 
}