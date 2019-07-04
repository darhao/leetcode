package leetcode.array_string;

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int continuous = 0;
        int maxContinuous = 0;
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		continuous = 0;
        	}else {
        		continuous++;
        		if(continuous > maxContinuous) {
        			maxContinuous = continuous;
        		}
        	}
		}
		return maxContinuous;
    }
	
}
