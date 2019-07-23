package leetcode.binarysearch;

import java.util.LinkedList;
import java.util.List;

public class ClosestElementsFinder {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr.length == 0) {
        	return new LinkedList<Integer>();
        }
    	
        int xi = findXIndex(x, arr);
        
        List<Integer> result = new LinkedList<Integer>();
        result.add(arr[xi]);
        
        int left = 1, right = 1;
        for (int i = 1; i < k; i++) {
			if(xi - left < 0) {
				result.add(arr[xi + right]);
				right++;
			}else if(xi + right > arr.length - 1) {
				result.add(0, arr[xi - left]);
				left++;
			}else if(-(arr[xi - left] - x) <= arr[xi + right] - x){
				result.add(0, arr[xi - left]);
				left++;
			}else {
				result.add(arr[xi + right]);
				right++;
			}
		}
        return result;
    }
    
    
    private int findXIndex(int x, int[] arr) {
    	if(x > arr[arr.length - 1]) {
    		return arr.length - 1;
    	}
    	
    	if(x < arr[0]) {
    		return 0;
    	}
    	
    	int left = 0, right = arr.length - 1, mid = 0;
    	while(left + 1 < right) {
    		mid = left + (right - left) / 2;
    		if(arr[mid] == x) {
    			return mid;
    		}else if(arr[mid] > x) {
    			right = mid;
    		}else {
    			left = mid;
    		}
    	}
    	if(-(arr[left] - x) <= arr[right] - x) {
    		return left;
    	}else {
    		return right;
    	}
    }
	
}
