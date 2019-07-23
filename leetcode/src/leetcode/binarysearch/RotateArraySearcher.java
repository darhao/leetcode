package leetcode.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class RotateArraySearcher {

    public int search(int[] nums, int target) {
    	if(nums.length == 0) {
    		return -1;
    	}
    	int minValueIndex = getMinValueIndex(nums);
    	return search0(minValueIndex, nums, target);
    }

    
	private int getMinValueIndex(int[] nums) {
		int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		int midOneLeft = mid == 0 ? nums.length - 1 : mid - 1;
    		int midOneRight = mid == nums.length - 1 ? 0 : mid + 1;
    		if(nums[midOneLeft] >= nums[mid] && nums[midOneRight] >= nums[mid]) {
    			return mid;
    		}else if(nums[mid] > nums[right]) {
    			left = mid + 1;
    		}else if(nums[mid] < nums[left]) {
    			right = mid - 1;
    		}else {
    			return left;
    		}
    	}
		return -1;
	}
	

	public int search0(int minValueIndex, int[] nums, int target) {
		int left = minValueIndex;
    	int right = minValueIndex == 0 ? nums.length - 1 : minValueIndex - 1;
    	int mid = 0;
    	Set<Integer> leftVisitSet = new HashSet<Integer>();
    	Set<Integer> rightVisitSet = new HashSet<Integer>();
		while(true) {
    		if(left <= right) {
    			mid = left + (right - left) / 2;
    		}else if(right < left) {
    			mid = (left + ((right + nums.length) - left) / 2) % nums.length;
    		}
    		if(target == nums[mid]) {
    			return mid;
    		}else if(target < nums[mid]){
    			right = mid == 0 ? nums.length - 1 : mid - 1;
    			if(!rightVisitSet.add(right)) {
    				return -1;
    			}
    		}else if(target > nums[mid]){
    			left = mid == nums.length - 1 ? 0 : mid + 1;
    			if(!leftVisitSet.add(left)) {
    				return -1;
    			}
    		}
    	}
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new RotateArraySearcher().search(new int[] {100,-2,3,6,9,10,11},10));
//		System.out.println(new RotateArraySearcher().search(new int[] {4,5,6,7,0,1,2},0)); //4
//		System.out.println(new RotateArraySearcher().search(new int[] {6,7,8,0,1,2,3,4,5},4)); //6
//		System.out.println(new RotateArraySearcher().search(new int[] {3,4,5,6,7,8,9,0,2},0)); //6
//		System.out.println(new RotateArraySearcher().search(new int[] {3,4,5,6,7,-1,0,1,2},0)); //6
//		System.out.println(new RotateArraySearcher().search(new int[] {1,2,3,6,7,9,10,11,12},0)); //6
//		System.out.println(new RotateArraySearcher().search(new int[] {1,2,3,6,7,9,10,11,-1},0)); //6
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3,0,1,2,3,8,-10},4)); //-1
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3,0,1,2,3,8,-10},-10)); //7
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3,0,1,2,3,8,-10},-9j)); //0
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3,0,1,2,3,8,-10},0)); //2
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3},-3)); //1
//		System.out.println(new RotateArraySearcher().search(new int[] {-9,-3},-9)); //0
		System.out.println(new RotateArraySearcher().search(new int[] {3, 5,1},3)); //-1
//		System.out.println(new RotateArraySearcher().search(new int[] {9,-3},9)); //0
//		System.out.println(new RotateArraySearcher().search(new int[] {9,-3},-3)); //1
//		System.out.println(new RotateArraySearcher().search(new int[] {999},-3)); //-1
//		System.out.println(new RotateArraySearcher().search(new int[] {999},999)); //0
//		System.out.println(new RotateArraySearcher().search(new int[] {},999));
	}
	
}
