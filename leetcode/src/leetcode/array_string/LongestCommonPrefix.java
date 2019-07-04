package leetcode.array_string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) {
    		return "";
    	}
    	if(strs.length == 1) {
    		return strs[0];
    	}
    	int index = 0;
    	char c = '\0';
    	boolean goAhead = true;
    	try {
			while(goAhead) {
				c = strs[0].charAt(index);
				for (String string : strs) {
					if(string.charAt(index) != c) {
						goAhead = false;
					}
				}
				if(!goAhead) {
					break;
				}
				index++;
			}
		} catch (Exception e) {
		}
    	return strs[0].substring(0, index);
    }
	
}
