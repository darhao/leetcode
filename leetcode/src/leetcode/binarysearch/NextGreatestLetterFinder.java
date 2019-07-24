package leetcode.binarysearch;

public class NextGreatestLetterFinder {

    public char nextGreatestLetter(char[] letters, char target) {
    	if(target < letters[0] || target >= letters[letters.length - 1]) {
    		return letters[0];
    	}
    	int left = 0;
    	int right = letters.length - 1;
    	int mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		char midLeftOne = mid == 0 ? '\0' : letters[mid - 1];
    		if(midLeftOne <= target && letters[mid] > target) {
    			return letters[mid];
    		}else if(letters[mid] > target){
    			right = mid - 1;
    		}else if(letters[mid] <= target){
				left = mid + 1;
    		}
    	}
		return '\0';
    }
	
}
