// alan vo 
// occc fall 2022 
// beginning programming 
// guessing game

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
	unsigned seed = time(0); // from the etext on random numbers section
	srand(seed); // also from etext on random numbers section
	int random = rand() % 1000; // to generate the random number 0-999
	int guess; // to store the guessing number 
	cout << "Welcome to the Guessing Game!" << endl; 
	cout << "Please guess a number (0-999): " << endl;
	cin >> guess; 
	int count = 1; // accumulator to count the total number of guesses 
	
	while (guess != random) {
		if (guess > random) {
			cout << "Too high, try again! " << endl; 
			cin >> guess;
			count++; 
		}
		if (guess < random) {
			cout << "Too low, try again! " << endl;
			cin >> guess; 
			count++;
		}
		if (guess == random) {
			cout << endl;
			cout << "Congratulations! You got the right number: " << random << endl;
			cout << "Amount of guesses that it took you: " << count << endl;	
			cout << "Thanks for playing!" << endl; 
		}
	}
		
return 0;
}