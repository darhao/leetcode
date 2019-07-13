package leetcode.hash;

public class TwoSum {
    
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i == j) {
					continue;
				}
				if(target == nums[i] + nums[j]) {
					int[] result = new int[2];
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;
    }
	
}
