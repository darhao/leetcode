package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovingGrouper {
	
	class MyString {
		String s;
		
		@Override
		public int hashCode() {
			if(s.isEmpty()) {
				return s.hashCode();
			}
			char[] cs = s.toCharArray();
			int d = cs[0] - 'a';
			for (int i = 0; i < cs.length; i++) {
				if(cs [i] - d >= 'a') {
					cs[i] = (char) (cs[i] - d);
				}else {
					cs[i] = (char) (cs[i] + 26 - d);
				}
			}
			return new String(cs).hashCode();
		}
		
		@Override
		public boolean equals(Object arg0) {
			return arg0.hashCode() == this.hashCode();
		}
		
		public MyString(String s) {
			this.s = s;
		}
	}

    public List<List<String>> groupStrings(String[] strings) {
    	Map<MyString, List<String>> map = new HashMap<>();
    	for (String string : strings) {
    		if(map.containsKey(new MyString(string))) {
    			map.get(new MyString(string)).add(string);
    		}else {
    			List<String> ss = new ArrayList<String>();
    			ss.add(string);
    			map.put(new MyString(string), ss);
    		}
		}
    	List<List<String>> result = new ArrayList<List<String>>();
    	for (List<String> list : map.values()) {
			result.add(list);
		}
    	return result;
    }
    
    public static void main(String[] args) {
		new MovingGrouper().groupStrings(new String[] {"az","ba"});
	}
	
}
