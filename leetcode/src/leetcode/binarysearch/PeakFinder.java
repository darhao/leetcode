package leetcode.binarysearch;

public class PeakFinder {

    public int findPeakElement(int[] nums) {
    	if(nums.length == 1) {//mid����߽磬midҲ���ұ߽�
    		return 0;
    	}
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while(right - left > 1) {
        	mid = left + (right - left) / 2;
        	if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {//mid�������ھӶ��� �J �K
        		return mid;
        	}else if(nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {//mid�����ھӴ�����ھ�С �K
        		right = mid;
        	}else if(nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {//mid�����ھӴ�����ھ�С �J
        		left = mid;
        	}else if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]){//mid�������ھӶ�С �K �J 
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
