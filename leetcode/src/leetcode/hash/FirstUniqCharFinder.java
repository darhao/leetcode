package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqCharFinder {

	class CharInfo {
		boolean isUniq = true;
		int firstIndex;
		public CharInfo(int firstIndex) {
			this.firstIndex = firstIndex;
		}
	}
	
    public int firstUniqChar(String s) {
    	Map<Character, CharInfo> map = new HashMap<>();
    	char[] cs = s.toCharArray();
    	for (int i = 0; i < cs.length; i++) {
			if(map.containsKey(cs[i])) {
				map.get(cs[i]).isUniq = false;
			}else {
				map.put(cs[i], new CharInfo(i));
			}
		}
    	int minIndex = s.length();
    	for (CharInfo charInfo : map.values()) {
			if(charInfo.isUniq == true && charInfo.firstIndex < minIndex) {
				minIndex = charInfo.firstIndex;
			}
		}
    	if(minIndex == s.length()) {
    		return -1;
    	}else {
    		return minIndex;
    	}
    }
	
}
