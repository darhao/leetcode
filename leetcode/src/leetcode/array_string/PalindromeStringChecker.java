package leetcode.array_string;

public class PalindromeStringChecker {

    public boolean isPalindrome(String s) {
    	if(s == null || s.length() == 0) {
    		return true;
    	}
        int left = 0, right = s.length() - 1;
        while(left < right) {
        	char lc = s.charAt(left);
        	while(!(lc >= 'a' && lc <= 'z' || lc >= 'A' && lc <= 'Z' || lc >= '0' && lc <= '9')) {
        		left++;
        		if(left > right) {
        			break;
        		}
        		lc = s.charAt(left);
        	}
        	
        	char rc = s.charAt(right);
        	while(!(rc >= 'a' && rc <= 'z' || rc >= 'A' && rc <= 'Z' || rc >= '0' && rc <= '9')) {
        		right--;
        		if(left > right) {
        			break;
        		}
        		rc = s.charAt(right);
        	}
        	
        	if(!(rc == lc || (rc >= 'a' && rc <= 'z' || rc >= 'A' && rc <= 'Z') && (lc >= 'a' && lc <= 'z' || lc >= 'A' && lc <= 'Z') && Math.abs(rc - lc) == ('a' - 'A'))) {
        		return false;
        	}
        	
        	left++;
        	right--;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
		System.out.println(new PalindromeStringChecker().isPalindrome("0P"));
	}
	
}
