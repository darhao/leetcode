package leetcode.hash;

public class MyHashMap {

	private final int BUCKET_SIZE = 1 * 1000 * 1000 + 1;
	private int[] values;
	
	
    /** Initialize your data structure here. */
    public MyHashMap() {
        values = new int[BUCKET_SIZE];
    	for (int i = 0; i < BUCKET_SIZE; i++) {
    		values[i] = -1;
		}
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        values[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	values[key] = -1;
    }
	
}
