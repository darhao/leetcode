package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int slow = 0, fast = 0, max = 0;
        Set<Character> characters = new HashSet<Character>();
        while(fast < s.length()) {
        	if(characters.add(s.charAt(fast))) {
        		if(characters.size() > max) {
        			max = characters.size();
        		}
        		fast++;
        	}else {
        		characters.remove(s.charAt(slow));
        		slow++;
        	}
        }
        return max;
    }
	
}
