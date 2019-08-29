package leetcode.hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencySorter {

	class Text {
		int times;
		char c;
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < times; i++) {
				sb.append(c);
			}
			return sb.toString();
		}
	}
	
	
	class TextComparator implements Comparator<Text> {
		@Override
		public int compare(Text o1, Text o2) {
			return o2.times - o1.times;
		}
	}
	
	
    public String frequencySort(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	for (char c : s.toCharArray()) {
    		map.put(c, map.getOrDefault(c, 0) + 1);
		}
    	List<Text> list = new LinkedList<>();
    	for (Character c : map.keySet()) {
    		Text text = new Text();
    		text.c = c;
    		text.times = map.get(c);
    		list.add(text);
		}
    	list.sort(new TextComparator());
    	StringBuilder sb = new StringBuilder();
    	for (Text text : list) {
			sb.append(text.toString());
		}
    	return sb.toString();
    }
    
    
    public static void main(String[] args) {
		System.out.println(new FrequencySorter().frequencySort("tree"));
	}
	
}
