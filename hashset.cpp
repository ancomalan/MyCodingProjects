//leetcode problem 705: designing hashset
class MyHashSet {
public:

    bool keys[1000001]; //array tracks existence of keys
    MyHashSet() {
        //initialize all keys to false
        for (int i = 0; i < 1000001; i++) {
            keys[i] = false;
        }
    }
    
    //inserts key into hashset
    void add(int key) {
        keys[key] = true;
    }
    
    //removes key from hashset
    void remove(int key) {
        keys[key] = false;
    }
    
    //returns whether key exists in hashset or not
    bool contains(int key) {
        return keys[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */