package leetcode.array_string;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
		boolean isFound = false;
    	if(nums.length == 0) {
    		return 0;
    	}
        int left = 0, right = 0, minLength = nums.length;
        while(true) {
        	int sum = getSum(nums, left, right);
        	if(sum >= s) {
        		isFound = true;
        		int length = right - left + 1;
        		if(length < minLength) {
        			minLength = length;
        		}
        		if(left == nums.length - 1 && right == nums.length - 1) {
        			break;
        		}
        		if(left < nums.length - 1) {
        			left++;
            	}
        		if(left > right) {
        			right++;
        		}
        	}else if(sum < s){
        		if(right < nums.length - 1) {
        			right++;
            	}else {
            		break;
            	}
        	}
        }
        if(isFound) {
        	return minLength;
        }else {
        	return 0;
        }
        
    }


	private int getSum(int[] nums, int left, int right) {
		int sum = 0;
		for (int i = left; i < right + 1; i++) {
			sum += nums[i];
		}
		return sum;
	}
    
    
    public static void main(String[] args) {
		System.out.println(new MinSubArrayLen().minSubArrayLen(4, new int[] {1,4,4}));
	}
	
}
