// alan vo 
// occc fall 2022
// beginning programming 
// word game 

#include <iostream>
#include <string>
using namespace std; 

int main() {
	string name, city, college, profession, animal, pet_name; 
	unsigned int age; //since age can never be negative 
	
	cout << "Please enter your name: ";
	getline(cin, name);
	cout << "Please enter your age: ";
	cin >> age; 
	cin.ignore();
	cout << "Please enter the city that you live in: "; 
	getline(cin, city);
	cout << "Please enter the college that you attend: ";
	getline(cin, college);
	cout << "Please enter your current profession: ";
	getline(cin, profession);
	cout << "Please enter the type of animal that you have: ";
	getline(cin, animal);
	cout << "Please enter your pet's name: "; 
	getline(cin, pet_name);
	cout << endl; 
	cout << "There once was a person named " << name << " who lived in " << city << "." << " At the age of " << age << ",\n" ;
	cout << name << " went to college at " << college << ". " << name << " graduated and went to work as a " << endl; 
	cout << profession << ". " << "Then, " << name << " adopted a(n) " << animal << " named " << pet_name << ". " << "They both lived" << endl; 
	cout << "happily ever after!";
	return 0;


}