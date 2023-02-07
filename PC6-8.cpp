// alan vo 
// occc fall 2022
// beginning programming 
// coin toss 
// I recieved some help from a YouTube video because I had trouble with randomizing the flips; it would either just list heads or tails 12 times in a row.
// source: https://www.youtube.com/watch?v=9dQUdT4D-uY

#include <iostream>
#include <cstdlib> // for random and srand
#include <ctime> // for time 
using namespace std; 

int coinToss(void); // prototype for coin toss function


int main() {
	int userFlip; // to store the amount flips inputted by user
	cout << "Welcome to Coin Toss!" << endl; 
	cout << "Please enter how many times you would like the coin to be flipped: ";
	cin >> userFlip;
	cout << endl;
	int randomNumber; // to store random number returned from coin toss function
	coinToss(); // call function
	unsigned seed = time(0); // Initially, I put lines 24-25 into the loop, and that's why it was not randomizing the number. I realized that the YouTube video had them outside the loop.
	srand(seed);
	int headsCount = 0; // to keep track of heads
	int tailsCount = 0; // to keep track of tails

	for (int i = 1; i <= userFlip; i++) {
		randomNumber = coinToss(); // call function to generate random number every time the loop iterates
		if (randomNumber == 0) {
			cout << "heads" << endl;
			headsCount++; 
		}
		else if (randomNumber == 1) {
			cout << "tails" << endl;
			tailsCount++;
		}
	}
	cout << endl;
	cout << "Total amount of heads: " << headsCount << endl;
	cout << "Total amount of tails: " << tailsCount << endl;
return 0;
}

int coinToss(void) { //defining the coinToss function 
	
	int randNum; // local variable for random number
		randNum = rand() % 2; // generate random number from 0 to 1 
		return randNum; // returns either 0 or 1 to the coin toss function, which is assigned to the randomNumber in the main function (line 30)
	}


