// ========================================
// HW3: Implement a Vector Class
// ========================================
// 
// In this assignment, we will implement 
// a vector class based on array, pointer 
// and dynamic memory allocation. 
// 
// The class has two private member 
// variables and some member functions. 
// Their designs are explained below. 
// 
// You can add new member functions 
// but not new member variables. In 
// addition, you cannot use any existing 
// vector-related library or function. 
// 
// 


#include <iostream>
using namespace std;

// 
// ======= Task =======
// Design and implement all member 
// functions of the MyVector class. 
class MyVector {

public:

	// The "vsize" function returns the size 
	// of the current vector.  
	int vsize();

	// The "empty" function returns 1 if the 
	// current vector has no element and 0 otherwise. 
	int empty();

	// The "at" function returns the idx_th element 
	// of the vector. It also returns -1 if "idx" 
	// is outside the range of the current vector.
	int at(int idx);

	// The "resize" function resizes the current 
	// vector into a vector of size n. Note there 
	// are two scenarios (in lecture slides) which 
	// may need to be addressed separately. 
	void resize(int n);

	// The "push_back" function adds a new element 
	// "x" to the end of the current vector. Note 
	// the vector size increases after addition. 
	void push_back(int x);

	// The "pop_back" function removes the last 
	// element from the current vector, but does 
	// nothing if the current vector is empty. 
	// Note the vector size decreases after pop. 
	void pop_back();

	// The "insert" function inserts a new element 
	// "x" as the idx_th element in the current vector.
	// It also does nothing if "idx" is outside the 
	// range of the current vector. 
	void insert(int idx, int x);

	// The "erase" function removes the idx_th element 
	// from the vector. It also does nothing if the 
	// current vector is empty or if "idx" is outside 
	// the range of the current vector. 
	void erase(int idx);

	// The constructor should initialize 
	// pointer "p" to NULL and "size" to 0. 
	MyVector();

private:

	int* p; // This pointer holds the vector (or,essentially, 
	// address of an array that holds the vector elements.)
	// Do remember to update it after some vector operations.

	int size; // This integer holds the size of the current 
	// vector. Do remember to update it after some 
	// vector operations. 
};

//implement constructor 
MyVector::MyVector() {
	p = NULL; //initialize pointer p to NULL
	size = 0; //inititalize size to 0
}

//implement vector size function
int MyVector::vsize() {
	return size;//returns the size (private data member) of the current vector
}

//implement empty function 
int MyVector::empty() {
	//The "empty" function returns 1 if the current vector has no element and 0 otherwise. 
	int flag; // variable used to return whether vector has element or not 
	if (size == 0) {
		flag = 1;
	}
	else {
		flag = 0;
	}
	return flag;

}

// implement The "at" function
int MyVector::at(int idx) {
	//function returns the idx_th element of the vector. It also returns -1 if "idx" is outside the range of the current vector.
	int range = size - 1;//index range of the current vector = size - 1 
	int flag; //used to return 
	//first check if in range, then return the element specified by the function
	if (idx >= 0 && idx <= range) {
		flag = p[idx];
	}
	else {
		flag = -1; //return -1 if outside of range or current vector
	}
	return flag;
}

//implement the resize function
void MyVector::resize(int n) {
	//resizes the current vector into a vector of size n. Note there are two scenarios (in lecture slides) which may need to be addressed separately. 
	int* newVector = new int[n];  // dynamically create a new vector with the specified size
	for (int i = 0; i < n; i++) {
		newVector[i] = p[i];  // assign elements from the old array to the new array
	}
	delete[] p;  // Delete the old vector to free the memory
	p = newVector;  // assign the address of the new array to the pointer 
	size = n;  // Update the size member variable 
}


//implement the "push_back" function 
void MyVector::push_back(int x) {
	// adds a new element "x" to the end of the current vector. Note the vector size increases after addition. 
	int* newArray = new int[size + 1];  // create a new array with size + 1 to store the old elements plus the new element
	for (int i = 0; i < size; i++) {
		newArray[i] = p[i];  // copy all elements from the old array to the new array
	}
	newArray[size] = x;  // Add the new element at the end of the new array
	delete[] p;  // Delete the old array to free up memory 
	p = newArray; //update the pointer to newArray
	size++;  // Increase the size member variable 

}

//implement popback function 
void MyVector::pop_back() {
	//The "pop_back" function removes the last
		// element from the current vector, but does 
		// nothing if the current vector is empty. 
		// Note the vector size decreases after pop. 


	//only do something if the current vector contains elements
	if (size > 0) {
		int* newArray = new int[size - 1];  // create a new array with size - 1
		for (int i = 0; i < size - 1; i++) {
			newArray[i] = p[i];  // Copy elements from the old array to the new array
		}
		delete[] p;  // delete the old array to free memory 
		p = newArray;  // Update the pointer to the new array location
		size--;  // Decrease the size of vector member variable 
	}
}


//implement insert function
void MyVector::insert(int idx, int x) {
	// The "insert" function inserts a new element 
	// "x" as the idx_th element in the current vector.
	// It also does nothing if "idx" is outside the 
	// range of the current vector. 

		//first check if idx is outside range 
	if (idx < 0 || idx > size) {
		return;  // Do nothing if the index is out of range
	}
	int* newArray = new int[size + 1];  // dynamically create a new array with size + 1 to fit the new element 
	for (int i = 0; i < idx; i++) {
		newArray[i] = p[i];  // Copy elements of old array to the new array and stop before the insertion point of the new element 
	}
	newArray[idx] = x;  // Insert the new element in desired index
	for (int i = idx; i < size; i++) {
		newArray[i + 1] = p[i];  // After inserting the element, continue copying the rest of the elements after the insertion point
	}
	delete[] p;  // delete to free up memory
	p = newArray;  // Update the pointer to the address of the new array
	size++;  // Increase the size variable
}


//implement erase function
void MyVector::erase(int idx) {
	// The "erase" function removes the idx_th element 
	// from the vector. It also does nothing if the 
	// current vector is empty or if "idx" is outside 
	// the range of the current vector. 

	if (idx < 0 || idx >= size || size == 0) {
		return;  // Do nothing if the index is out of range or vector is empty
	}
	int* newArray = new int[size - 1];  // create a new array with size - 1 for the element that is going to be removed
	for (int i = 0; i < idx; i++) {
		newArray[i] = p[i];  // Copy elements before the erased element
	}
	for (int i = idx + 1; i < size; i++) {
		newArray[i - 1] = p[i];  // Copy elements after the erased element
	}
	delete[] p;  // Deallocate the old array to free up memory 
	p = newArray;  // Update the pointer to the new array
	size--;  // Decrease the size
}





// The main function has been completed for you. 
// It is used to test your implmentation. 
// You should not modify it (unless there is typo).
int main()
{
	MyVector x;

	int mode;
	int new_size, idx, data;
	int temp;

	cin >> mode; // This decides which function to test. 
	cin >> new_size >> idx >> data;

	// Mode 0: test push_back(), vsize() and at()
	if (mode == 0) {

		while (cin >> temp) {
			x.push_back(temp);
		}

		cout << x.vsize() << '\n';

		for (int i = 0; i < x.vsize(); i++) {
			cout << x.at(i) << '\n';
		}
	}
	// Mode 1: test resize()
	else if (mode == 1)
	{
		while (cin >> temp) {
			x.push_back(temp);
		}

		x.resize(new_size);

		cout << x.vsize() << '\n';

		for (int i = 0; i < x.vsize(); i++) {
			cout << x.at(i) << '\n';
		}
	}
	// Mode 2: test pop_back()
	else if (mode == 2) {

		while (cin >> temp) {
			x.push_back(temp);
		}

		x.pop_back();

		cout << x.vsize() << '\n';

		for (int i = 0; i < x.vsize(); i++) {
			cout << x.at(i) << '\n';
		}
	}
	// Mode 3: test insert()
	else if (mode == 3) {

		while (cin >> temp) {
			x.push_back(temp);
		}

		x.insert(idx, data);

		cout << x.vsize() << '\n';

		for (int i = 0; i < x.vsize(); i++) {
			cout << x.at(i) << '\n';
		}
	}
	// Mode 4: test erase()
	else if (mode == 4) {

		while (cin >> temp) {
			x.push_back(temp);
		}

		x.erase(idx);

		cout << x.vsize() << '\n';

		for (int i = 0; i < x.vsize(); i++) {
			cout << x.at(i) << '\n';
		}
	}
	else {
		cout << "Wrong Mode Input!";
	}

	return 0;
}