package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	for (Integer i : nums) {
			if(set.contains(i)) {
				set.remove(i);
			}else {
				set.add(i);
			}
		}
    	for (Integer i : set) {
			return i;
		}
    	return 0;
    }
	
}
