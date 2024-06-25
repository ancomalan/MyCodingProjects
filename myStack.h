// stack class - last in, first out!
template <class Type>
class myStack {
public:
    myStack(); // default constructor that sets topOfMyStack to NULL
    myStack(const myStack<Type>&); //copy constructor that performs a deep copy of the copy object to the *this object
    const myStack<Type>& operator =(const myStack<Type>&); //assignment operator that does a deep copy ot the rhs to the *this object
    ~myStack(); //destructor, deallocates the stack object

    void push(const Type&); //pushes a new node to the top of the stack (aka a head insert) and assigns insert into this new node’s item field
    void pop(); //removes the top element (head removal) if the stack is not empty, otherwise nothing happens
    Type top() const; //returns the item of the top node in the stack
    bool isEmpty() const; //returns true if the stack is empty and false if the stack is not empty

private:
    //struct node is each element of the stack
    //each element of the node contains these data members
    struct node {
        Type item; 
        node* next; // a pointer pointing to the next node in the stack
    };
    node* topOfMyStack; //pointer that points to top of the stack, basically a head pointer
};

//default constructor
template <class Type>
myStack<Type>::myStack() {
    topOfMyStack = NULL; //sets topOfMyStack to NULL
}

//copy constructor
template <class Type>
myStack<Type>::myStack(const myStack<Type> &copy) {
    
    //create a head pointer for the stack that we are copying FROM so that we can traverse through it 
    node* headOfCopyStack = copy.topOfMyStack; // assign top of stack (which acts as a head pointer)
    node* temp = headOfCopyStack; //create a temp node pointer to traverse through the stack
    node* previousNode = NULL; //keeps track of previous node and initialize to NULL initially because first node copied has nothing before it 

    //traverse through copy stack and copy each node 
    while (temp != NULL) {
        node* newNode = new node;     //dynamically create new node 

       //copy data from node in copy stack and assign to this new node 
        newNode = temp->item; 
        newNode = temp->next;

        //if the first node that is copied
        if (previousNode == NULL) {
            topOfMyStack = newNode; //set this first node that we added as the head  
        }
        //if not the first node, have previous node point point to this new node
        else { 
            previousNode->next = newNode;
        }
        previousNode = newNode; //update previous node to new node that was added

        temp = temp->next;//move head to next node in copystack
    }
}




//assignment operator
template <class Type>
const myStack<Type>& myStack<Type>::operator =(const myStack<Type>& copy) {

    //create a head pointer for the stack that we are copying FROM so that we can traverse through it 
    node* headOfCopyStack = copy.topOfMyStack; // assign top of stack (which acts as a head pointer)
    node* temp = headOfCopyStack; //create a temp node pointer to traverse through the stack
    node* previousNode = NULL; //keeps track of previous node and initialize to NULL initially because first node copied has nothing before it 

    //traverse through copy stack and copy each node 
    while (temp != NULL) {
        node* newNode = new node;     //dynamically create new node 

        //copy data from node in copy stack and assign to this new node 
        newNode = temp->item;
        newNode = temp->next;

        //if the first node that is copied
        if (previousNode == NULL) {
            topOfMyStack = newNode; //set this first node that we added as the head  
        }
        //if not the first node, have previous node point point to this new node
        else {
            previousNode->next = newNode;
        }
        previousNode = newNode; //update previous node to new node that was added

        temp = temp->next;//move head to next node in copystack
        }
    }



//destructor: deallocates stack object
template <class Type>
myStack<Type>::~myStack() {
    //while the stack is not empty, remove all elements from the stack
    while (!isEmpty()) {
        pop(); 
    }
}

//push function: pushes a new node to the top of the stack (aka a head insert) and assigns insert into this new node’s item field
template <class Type>
void myStack<Type>::push(const Type& insert) {
    node* newNode = new node; //dynamically create a new node 
    newNode->next = topOfMyStack; //have new node point to current head 
    topOfMyStack = newNode; //update head pointer to newNode
    newNode->item = insert; //assign insert into new node's item field 

}


//pop function: removes the top element (head removal) if the stack is not empty,otherwise nothing happens
template <class Type>
void myStack<Type>::pop() {
    //perform only if the stack is NOT empty
    if (!isEmpty()) {
        node* temp = topOfMyStack; //create a temporary node that points to the head of the stack
        topOfMyStack = topOfMyStack->next; //assign new head to next node in the stack
        delete temp; //delete old head
    }
}


//returns the item of top node in the stack
template <class Type>
Type myStack<Type>::top() const {
    if (!isEmpty()) {
        return topOfMyStack->item;
    }
}


//returns true if the stack is empty and false if the stack is not empty
template <class Type>
bool myStack<Type>::isEmpty() const {

 
    //if stack is empty, return true
    if (topOfMyStack == NULL) {
        return true;
    }
    //otherwise return false
    else {
        return false; 
    }


}