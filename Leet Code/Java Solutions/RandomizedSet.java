/*
 * From Leet Code: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

    You must implement the functions of the class such that each function works in average O(1) time complexity.

 
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 
 */
import java.util.HashMap;
import java.util.ArrayList;
public class RandomizedSet {
    //initialize data structure, we will use an array list to store the values and a hash map to store the index of the values
    //key will be the value and value will be the index
    private HashMap<Integer, Integer> indexMap;
    //array list to store the values
    private ArrayList<Integer> values; 
    public RandomizedSet() {
        this.indexMap = new HashMap<Integer, Integer>();
        this.values = new ArrayList<Integer>();
    }
    
    public static void main (String[] args){
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();
        System.out.println("param_1: " + param_1 + "\nparam_2: " + param_2 + "\nparam_3: " + param_3);
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)){
            return false;
        }
        //add the value to the array list
        values.add(val);
        //add the value and the index to the hash map
        indexMap.put(val, values.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)){
            return false;
        }
        //to ensure no mismatches between the map and array when removing a value, 
        //we will swap the value at the index with the last value in the array list
        //so we are always removing the last value in the array list
        
        //get the index of the value
        int index = indexMap.get(val);
        //get the last value in the array list
        int lastValue = values.get(values.size() - 1);
        //set the value at the index to the last value
        values.set(index, lastValue);
        //update the index of the last value in the hash map
        indexMap.put(lastValue, index);
        //remove the last value from the array list
        values.remove(values.size() - 1);
        //remove the value from the hash map
        indexMap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        //choose random number between 0 and the size of the array list
        return values.get((int)(Math.random() * values.size()));
    }
}

