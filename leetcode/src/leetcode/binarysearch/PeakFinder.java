package leetcode.binarysearch;

public class PeakFinder {

    public int findPeakElement(int[] nums) {
    	if(nums.length == 1) {//mid是左边界，mid也是右边界
    		return 0;
    	}
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while(right - left > 1) {
        	mid = left + (right - left) / 2;
        	if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {//mid比左右邻居都大 ↗ ↘
        		return mid;
        	}else if(nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {//mid比右邻居大比左邻居小 ↘
        		right = mid;
        	}else if(nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {//mid比左邻居大比右邻居小 ↗
        		left = mid;
        	}else if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]){//mid比左右邻居都小 ↘ ↗ 
        		left = mid;
        	}
        }
        if(nums[left] > nums[right]) {
        	return left;
        }else {
        	return right;
        }
    }
	
}
