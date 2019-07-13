package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
    	char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
			if(map.containsKey(ss[i])) {
				if(map.get(ss[i]) != ts[i]) {
					return false;
				}
			}else {
				//字母出现重复映射则表示不是同构字符串
				for (char c : map.values()) {
					if(c == ts[i]) {
						return false;
					}
				}
				map.put(ss[i], ts[i]);
			}
		}
        return true;
    }
    
    
    public static void main(String[] args) {
    	System.out.println(new IsomorphicString().isIsomorphic("ab", "aa"));
		System.out.println(new IsomorphicString().isIsomorphic("interesting", "asobrbwoasg"));
	}
	
}
