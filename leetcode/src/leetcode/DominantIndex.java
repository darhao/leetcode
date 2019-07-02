package leetcode;

public class DominantIndex {

	int max;
	int maxIndex;
	
    public int dominantIndex(int[] nums) {
    	getMax(nums);
    	for (int i = 0; i < nums.length; i++) {
			if(i == maxIndex) {
				continue;
			}
			if(nums[i] == 0) {
				continue;
			}
			if(max / nums[i] < 2) {
				return -1;
			}
		}
    	return maxIndex;
    }
    

	private void getMax(int[] nums) {
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i] > max) {
    			maxIndex = i;
    			max = nums[i];
    		}
		}
	}
	
}
