package leetcode.array_string;

public class KthLargestFinder {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if(nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
        return nums[nums.length - k];
    }
	
}
