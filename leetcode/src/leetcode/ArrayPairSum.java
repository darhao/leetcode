package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
    	nums = sort(nums);
    	int result = 0;
    	for (int i = 0; i < nums.length; i+=2) {
			result += nums[i];
		}
    	return result;
    }

    
	private int[] sort(int[] nums) {
		if(nums.length < 2) {
			return nums;
		}
		int[] left = new int[nums.length / 2];
		int[] right = new int[nums.length / 2 + nums.length % 2];
		for (int i = 0; i < nums.length / 2; i++) {
			left[i] = nums[i];
		}
		for (int i = 0; i < nums.length / 2 + nums.length % 2; i++) {
			right[i] = nums[i + nums.length / 2];
		}
		left = sort(left);
		right = sort(right);
		List temp = new ArrayList<>();
		int l = 0, r = 0;
		while(l < left.length && r < right.length) {
			if(left[l] <= right[r]) {
				temp.add(left[l]);
				l++;
			}else {
				temp.add(right[r]);
				r++;
			}
		}
		while(l < left.length) {
			temp.add(left[l]);
			l++;
		}
		while(r < right.length) {
			temp.add(right[r]);
			r++;
		}
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = (int) temp.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		new ArrayPairSum().arrayPairSum(new int[] {1,2,3,2});
	}

}
