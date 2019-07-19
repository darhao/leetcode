package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

	/** Initialize your data structure here. */
    public TwoSumIII() {
        
    }
    
    Map<Integer, Boolean> map = new HashMap<>();
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) {
        	map.put(number, true);
        }else {
        	map.put(number, false);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
    	for (Integer i : map.keySet()) {
			if(value - i == i) {
				if(map.get(i)) {
					return true;
				}
			}else {
				if(map.containsKey(value - i)) {
					return true;
				}
			}
		}
        return false;
    }
	
}
