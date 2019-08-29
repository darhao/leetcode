package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
        	char c = t.charAt(i);
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
        if(map.keySet().size() >= map2.keySet().size()) {
        	for (Character c : map.keySet()) {
    			if(map2.get(c) == null || map.get(c).intValue() != map2.get(c).intValue()) {
    				return false;
    			}
    		}
        }else {
        	for (Character c : map2.keySet()) {
    			if(map.get(c) == null || map2.get(c).intValue() != map.get(c).intValue()) {
    				return false;
    			}
    		}
        }
        return true;
    }
	
}
