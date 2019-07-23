package leetcode.binarysearch;

public class RangeSearcher {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
        	return new int[] {-1,-1};
        }
        
        Integer[] result = new Integer[2];
        
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
        	mid = left + (right - left) / 2;
        	if(nums[mid] == target) {
        		if(mid == 0) {
        			result[0] = mid;
        			break;
        		}
        		if(nums[mid - 1] != target) {
        			result[0] = mid;
        			break;
        		}
        		right = mid - 1;
        	}else if(nums[mid] < target) {
        		left = mid + 1;
        	}else {
        		right = mid - 1;
        	}
        }
        
        left = 0; right = nums.length - 1; mid = 0;
        while(left <= right) {
        	mid = left + (right - left) / 2;
        	if(nums[mid] == target) {
        		if(mid == nums.length - 1) {
        			result[1] = mid;
        			break;
        		}
        		if(nums[mid + 1] != target) {
        			result[1] = mid;
        			break;
        		}
        		left = mid + 1;
        	}else if(nums[mid] < target) {
        		left = mid + 1;
        	}else {
        		right = mid - 1;
        	}
        }
        
        if(result[0] == null) {
        	return new int[] {-1,-1};
        }else {
        	int[] res = new int[2];
        	res[0] = result[0];
        	res[1] = result[1];
        	return res;
        }
    }
	
}
