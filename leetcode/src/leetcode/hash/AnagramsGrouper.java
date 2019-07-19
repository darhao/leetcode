package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsGrouper {
	
	class MyString {
		String s;
		
		@Override
		public int hashCode() {
			char[] cs = s.toCharArray();
			for (int i = 0; i < cs.length; i++) {
				for (int j = 0; j < cs.length - i - 1; j++) {
					if(cs[j] > cs[j+1]) {
						char temp = cs[j];
						cs[j] = cs[j+1];
						cs[j+1] = temp;
					}
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
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<MyString, List<String>> map = new HashMap<>();
    	for (String string : strs) {
    		if(map.containsKey(new MyString(string))) {
    			map.get(new MyString(string)).add(string);
    		}else {
    			List<String> strings = new ArrayList<String>();
    			strings.add(string);
    			map.put(new MyString(string), strings);
    		}
		}
    	List<List<String>> result = new ArrayList<List<String>>();
    	for (List<String> list : map.values()) {
			result.add(list);
		}
    	return result;
    }
	
}
