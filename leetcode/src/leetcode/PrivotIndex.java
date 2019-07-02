package leetcode;

public class PrivotIndex {

    public int pivotIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int leftSum = getLeft(i, nums);
			int rightSum = getRight(i, nums);
			if(leftSum == rightSum) {
				return i;
			}
		}
		return -1;
    }

	private int getLeft(int i, int[] nums) {
		int sum = 0;
		for (int j = 0; j < i; j++) {
			sum += nums[j];
		}
		return sum;
	}

	private int getRight(int i, int[] nums) {
		int sum = 0;
		for (int j = i + 1; j < nums.length; j++) {
			sum += nums[j];
		}
		return sum;
	}
    
}
