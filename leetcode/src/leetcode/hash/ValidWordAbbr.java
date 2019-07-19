package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
	
	Map<Word, Set<String>> words = new HashMap<>();
	
	class Word{
		String s;
		
		public Word(String s) {
			this.s = s;
		}
		
		@Override
		public int hashCode() {
			if(s.length() <= 2) {
				return s.hashCode();
			}
			return new StringBuilder().append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1)).toString().hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			return hashCode() == obj.hashCode();
		}
	}
	
    public ValidWordAbbr(String[] dictionary) {
        for (String string : dictionary) {
        	if(words.containsKey(new Word(string))) {
        		words.get(new Word(string)).add(string);
        	}else {
        		Set<String> set = new HashSet<String>();
        		set.add(string);
        		words.put(new Word(string), set);
        	}
		}
    }
    
    public boolean isUnique(String word) {
    	if(words.containsKey(new Word(word))){
    		for (String string : words.get(new Word(word))) {
				if(!word.equals(string)) {
					return false;
				}
			}
    		return true;
    	}else {
    		 return true;
    	}
    }
}
