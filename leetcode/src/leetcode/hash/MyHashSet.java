package leetcode.hash;

public class MyHashSet {

	private final int BUCKET_SIZE = 1 * 1000 * 1000 + 1;
	private int[] data;
	
	
    /** Initialize your data structure here. */
    public MyHashSet() {
    	data = new int[BUCKET_SIZE];
    	for (int i = 0; i < BUCKET_SIZE; i++) {
			data[i] = -1;
		}
    }
    
    
    public void add(int key) {
        data[key] = key;
    }
    
    
    public void remove(int key) {
    	data[key] = -1;
    }
    
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] != -1;
    }
    
    
    public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(1);
		myHashSet.add(2);
		myHashSet.contains(1);
		myHashSet.contains(3);
	}
	
}
