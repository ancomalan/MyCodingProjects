//alan vo 
//ou spring 2024
//data structures 
//hw4 - linked lists
// ========================================
// HW4: Implement a Singly List Class
// ========================================
// In this assignment, we will implement
// a singly linked list class based on
// a node class.
//
// The Node class has been defined to you.
// Do not modify it.
//
// The List class has been partly defined
// for you. It has one private variable
// "head" and several public functions.
// The constructor and Print function have been
// defined for you (do not modify them), and
// your task is to implement other functions.
//
// You can add new member functions to the
// List class but not new member variables.
// In addition, you cannot use any existing
// list-related library or function.
#include <iostream>
using namespace std;

//Node class
class Node {
private:
    int SID;
    float GPA;
    Node* p_next;

public:
    void Set_SID(int x);
    void Set_GPA(float y);
    int Get_SID();
    float Get_GPA();
    void Set_Pnext(Node* p);
    Node* Get_Pnext();
    Node();
};

void Node::Set_SID(int x) {
    SID = x;
}

void Node::Set_GPA(float y) {
    GPA = y;
}

int Node::Get_SID() {
    return SID;
}

float Node::Get_GPA() {
    return GPA;
}

void Node::Set_Pnext(Node* p) {
    p_next = p;
}

Node* Node::Get_Pnext() {
    return p_next;
}

Node::Node() {
    SID = -1;
    GPA = -1;
    p_next = NULL;
}

//List class
class List {
private:
    Node* head; 

public:
    List();

    void PrtSID();

    void Create();

    int Lsize();

    Node* Find(int key);

    int Insert(Node* p, int idx);

    int Remove(int idx);

    void Reverse();

    void Clear();
};

//constructor
List::List() {
    head = NULL;
}

//print SID function
void List::PrtSID() {
    Node* temp = head;
    while (temp != NULL) {
        cout << temp->Get_SID() << " ";
        temp = temp->Get_Pnext();
    }
    cout << endl;
}

//implement Create function
void List::Create() {
//creates a singly linked list based on our inputs and assigns its
// head node's address to the "head" pointer.
//
// To be specific, when we run Create(),
// the program should wait for us to input
// the SID and GPA of an arbitrary number
// of students. After Create() is done,
// the linked list should have been created
// and accessible through "head".
//
// The format of input should be as follows:
//
// sid_1 gpa_1 sid_2 gpa_2 sid_3 gpa_3 ......
//
// Here, sid_i and gpa_i are SID and GPA of
// the i_th input student. A new node is always
// added to the head of the list.

    int sid;
    float gpa; 

    //exit the while loop if user inputs anything other than integer or float (null/NULL for example)
    while (cin >> sid >> gpa) {
        Node* newNode = new Node; //dynamically create new node
        newNode->Set_SID(sid); 
        newNode->Set_GPA(gpa);
        newNode->Set_Pnext(head); //link current node's address to current head
        head = newNode; //update head pointer
    }
}

int List::Lsize() {
// Lsize function returns the number
// of nodes in the list. Return 0 if
// the list is empty.
    int count = 0; //running total to keep track of how many nodes there are
   
    //traverse through list
    Node* temp = head;
    while (temp != NULL) {
        count++;
        temp = temp->Get_Pnext();
    }

    return count;
}

Node* List::Find(int key) {
// Find function returns address of
// the node in the list whose SID = key.
// Return NULL if no match is found.

    //traverse through list
    Node* temp = head;
    while (temp != NULL) {
        if (temp->Get_SID() == key) {
            return temp;
        }
        temp = temp->Get_Pnext(); //move to the next node in the list until it reaches NULL
    }

    return NULL; //if no match found, return NULL
}

int List::Insert(Node* p, int idx) {
// Insert function inserts a new node
// (whose address is stored at "p")
// as the idx_th node in the list.
// Return 1 if insertion is successful
// and return -1 if idx is out of range.
// A valid range is [1, Lsize+1],
// where "1" means adding to head
// and "Lsize+1" means adding to tail.

    //check for if index is out of range 
    int size = Lsize();
    if (idx < 1 || idx > size + 1) {
        return -1;
    }

    //if index is 1, add to head
    if (idx == 1) {
        p->Set_Pnext(head); //link p to current head
        head = p; //update head pointer to p 
    }
    else {
        Node* temp = head;
        for (int i = 1; i < idx - 1; i++) {
            temp = temp->Get_Pnext();
        }

        p->Set_Pnext(temp->Get_Pnext());
        temp->Set_Pnext(p);
    }

    return 1; //return 1 for successful insertion
}

int List::Remove(int idx) {
// Remove function removes the idx_th
// node from the list. Return 1 if
// removal is successful and -1 if
// idx is out of range.
// A valid range is [1, Lsize],
// where "1" means removing head
// and "Lsize" means removing tail.

    //check for invalid range
    int size = Lsize();
    if (idx < 1 || idx > size) {
        return -1;
    }

    Node* temp = head;

    //if index is 1, remove head
    if (idx == 1) {
        head = head->Get_Pnext();
    }
    else {
        for (int i = 1; i < idx - 1; i++) {
            temp = temp->Get_Pnext();
        }

        Node* toRemove = temp->Get_Pnext();
        temp->Set_Pnext(toRemove->Get_Pnext());
        delete toRemove;
    }

    return 1; //return 1 for successful removal
}

void List::Reverse() {
// Reverse function reserves the list.
// For example, if the current list has
// three nodes A->B->C, after running
// Reverse the order should be C->B->A.
// As another example, if we call the
// print function and get 246, after
// running Reverse we should get 642.
    Node* prev = NULL;
    Node* current = head;
    Node* next = NULL;

    while (current != NULL) {
        next = current->Get_Pnext();
        current->Set_Pnext(prev);
        prev = current;
        current = next;
    }

    head = prev;
}

void List::Clear() {
// Clear function removes all nodes from
// the list (so it becomes an empty list).
    while (head != NULL) {
        Node* temp = head;
        head = head->Get_Pnext();
        delete temp;
    }
}

int main() {
    int mode, key, sid, idx;
    float gpa;

    cin >> mode >> key >> sid >> gpa >> idx;

    List x;
    x.Create();

    if (mode == 0) {
        x.PrtSID();
    }
    else if (mode == 1) {
        cout << x.Lsize() << endl;
    }
    else if (mode == 2) {
        Node* temp = x.Find(key);
        if (temp == NULL) {
            cout << -1 << endl;
        }
        else {
            cout << temp->Get_GPA() << endl;
        }
    }
    else if (mode == 3) {
        Node* temp = new Node;
        temp->Set_SID(key);
        temp->Set_GPA(3.5);
        x.Insert(temp, idx);
        x.PrtSID();
    }
    else if (mode == 4) {
        x.Remove(idx);
        x.PrtSID();
    }
    else if (mode == 5) {
        x.Reverse();
        x.PrtSID();
    }
    else if (mode == 6) {
        x.Clear();
        cout << x.Lsize() << endl;
    }

    return 0;
}
