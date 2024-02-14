//alan vo 
//ou spring 2024
//data structures
//hw1 (02/03/24)

// ======= Task 1 =======
// Complete the header files
#include <iostream>
using namespace std;
// === End of Task 1 ====

// ======= Task 2 =======
// Design and implement all member functions of the
// following two classes: Student and University.
// All member functions must be implemented outside
// the class definitions.
//

class Student {
public:
	void set_SID(int x); // It assigns x to SID.
	void prt_SID(); // It prints SID.
	void set_GPA(float y);// It assigns y to GPA.
	void prt_GPA(); // It prints GPA.
	void reset(); // It resets SID and GPA to -1.
	float get_GPA(); // It returns GPA.

	// Constructor. It initializes both SID and GPA to -1.
	Student() {
		SID = -1;
		GPA = -1;
	};

private:
	int SID; // It holds a student's ID.
	float GPA; // It holds a student's GPA.
};

//implement Student member functions outside class
void Student::set_SID(int x) {
	SID = x;
}
void Student::prt_SID() {
	cout << SID;
}
void Student::set_GPA(float y) {
	GPA = y;
}
void Student::prt_GPA() {
	cout << GPA;
}
void Student::reset() {
	SID = -1;
	GPA = -1;
}
float Student::get_GPA() {
	return GPA;
}


class University {
public:
	void set_Stu(Student x[]);// It assigns elements of array x to array Sooner.
	float GPA_Mean(); // It prints the mean GPA of the five students held by Sooner[5].
	float GPA_Max(); // It prints the max GPA of these five students.
	float GPA_Min(); // It prints the min GPA of these five students.
	University() {
		Student(); 		// Constructor. Initialize all student SID and GPA to - 1 by calling Student constructor.
	}
private:
	Student Sooner[5]; // It holds the records of five students.
};

//implement University member functions outside of class
void University::set_Stu(Student x[]) {
	//assign elements of array x to array Sooner
	for (int i = 0; i < 5; i++) {
		Sooner[i] = x[i];
	}
}
float University::GPA_Mean() {
	float average = (Sooner[0].get_GPA() + Sooner[1].get_GPA() + Sooner[2].get_GPA() + Sooner[3].get_GPA() + Sooner[4].get_GPA()) / 5;
	cout << average; //print out average/mean GPA
	return average;
}
float University::GPA_Max() {
	float highestGPA = Sooner[0].get_GPA(); //initialize highest GPA to first student and use first student's GPA to compare with the rest.
	for (int i = 1; i <= 4; i++) {
		//loop through the rest of the students to find the highest GPA
		if (Sooner[i].get_GPA() > highestGPA) {
			highestGPA = Sooner[i].get_GPA();
		}
	}
	cout << highestGPA; //print out the highest GPA 
	return highestGPA;
}
float University::GPA_Min() {
	float lowestGPA = Sooner[0].get_GPA(); //initialize lowest GPA to first student and use to compare with the other students
	for (int i = 1; i <= 4; i++) {
		//loop through rest of students to find lowest GPA 
		if (Sooner[i].get_GPA() < lowestGPA) {
			lowestGPA = Sooner[i].get_GPA();
		}
	}
	cout << lowestGPA; //print out lowest GPA
	return lowestGPA;

}
// === End of Task 2 ====

int main()
{
	Student x[5]; //create an array with Student objects, called x with size 5
	University OU;
	// ======= Test 1 =======
	// This tests your constructor function,
	// print function and header files.
	for (int i = 0; i < 5; i++) {
		x[i].prt_SID(); cout << ' ';
		x[i].prt_GPA(); cout << endl;
	}
	// === End of Test 1 ====
	// ======= Task 3 =======
	// Write a program that takes the SID
	// and GPA of five students as input
	// and assigns them to x[5].
	// Format of the inputs should be (with space)
	// SID1 GPA1 SID2 GPA2 SID3 GPA3 SID4 GPA4 SID5 GPA5

	int SID1, SID2, SID3, SID4, SID5; //store student IDs
	float GPA1, GPA2, GPA3, GPA4, GPA5; //store GPAs
	cin >> SID1 >> GPA1 >> SID2 >> GPA2 >> SID3 >> GPA3 >> SID4 >> GPA4 >> SID5 >> GPA5;
	//set gpa and id for all students using data inputted from the user
	x[0].set_GPA(GPA1);
	x[0].set_SID(SID1);
	x[1].set_GPA(GPA2);
	x[1].set_SID(SID2);
	x[2].set_GPA(GPA3);
	x[2].set_SID(SID3);
	x[3].set_GPA(GPA4);
	x[3].set_SID(SID4);
	x[4].set_GPA(GPA5);
	x[4].set_SID(SID5);


	// === End of Task 3 ====
	// ======= Test 2 =======
	// This tests your set function
	for (int i = 0; i < 5; i++) {
		x[i].prt_SID(); cout << ' ';
		x[i].prt_GPA(); cout << endl;
	}
	// === End of Test 2 ====
	// ======= Test 3 =======
	// This tests your University class.
	OU.set_Stu(x);
	OU.GPA_Mean(); cout << ' ';
	OU.GPA_Max(); cout << ' ';
	OU.GPA_Min(); cout << endl;
	// === End of Test 3 ====
	// ======= Test 4 =======
	// This tests your reset function.
	for (int i = 0; i < 5; i++) {
		x[i].reset();
		x[i].prt_SID(); cout << ' ';
		x[i].prt_GPA(); cout << endl;
	}
	// === End of Test 4 ====
	return 0;
}