#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std; 

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        
        //define unordered set 
        unordered_set<int> hashset;
        
        //loop through array, returning true if any value appears at least twice
        for (int value: nums){
             //if value already exists in set (count == 1), this means current key is a duplicate so we can return true
            if (hashset.count(value) == 1){
                return true;
            }
            hashset.insert(value); 
        }
        return false; //if every element is distinct
    }
};