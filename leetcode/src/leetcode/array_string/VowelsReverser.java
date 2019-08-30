package leetcode.array_string;

public class VowelsReverser {

    public String reverseVowels(String s) {
    	if(s == null || s.length() == 0) {
    		return s;
    	}
    	StringBuilder sb = new StringBuilder(s);
        int left = 0, right = sb.length() - 1;
        while(left < right) {
        	char lc = sb.charAt(left);
        	while(!isVowels(lc)) {
        		left++;
        		if(left > right) {
        			break;
        		}
        		lc = sb.charAt(left);
        	}
        	
        	char rc = sb.charAt(right);
        	while(!isVowels(rc)) {
        		right--;
        		if(left > right) {
        			break;
        		}
        		rc = sb.charAt(right);
        	}
        	
        	if(left < right) {
        		sb.setCharAt(left, rc);
            	sb.setCharAt(right, lc);
        	}
        	
        	left++;
        	right--;
        }
        return sb.toString();
    }
    
    
    private boolean isVowels(char c) {
    	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
	
    
    public static void main(String[] args) {
		System.out.println(new VowelsReverser().reverseVowels("leetcode"));
	}
}
