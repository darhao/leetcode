package leetcode.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
    	if(target < nums[0] || target > nums[nums.length - 1]) {
    		return -1;
    	}
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	do{
    		if(right - left == 1) {
    			if(target == nums[left]) return left;
    			if(target == nums[right]) return right;
    			return -1;
    		}
    		mid = (left + right) / 2;
    		if(target == nums[mid]) {
    			return mid;
    		}else if(target < nums[mid]){
    			right = mid;
    		}else if(target > nums[mid]){
				left = mid;
    		}
    	}while(true);
    }
    
}
