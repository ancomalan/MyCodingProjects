class MyHashMap {
public:
    int data[1000001]; // array to hold key-value pairs, assuming keys are non-negative integers
    bool exists[1000001]; // boolean array to track if a key already exists

    //initialize object with empty map
    MyHashMap() {
        // Initialize all entries to -1 (indicating no value)
        for (int i = 0; i < 1000001; i++){
            data[i] = -1; //indicates no mapping for any key initially 
            exists[i] = false; // mark all keys as non-existent
        }
    }
    
    //put key-value pair into the map 
    void put(int key, int value) {
        data[key] = value; 
        exists[key] = true; // mark the key as existing
    }
    
    //return the value that the key maps to 
    int get(int key) {
        return data[key];
    }
    
    //remove the key and corresponding value 
    void remove(int key) {
        data[key] = -1; // set the value to -1 to indicate no mapping
        exists[key] = false; // mark the key as non-existent
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */