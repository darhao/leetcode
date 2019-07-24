package leetcode.binarysearch;

public class PerfectSquareFinder {

    public boolean isPerfectSquare(int num) {
    	int left = 0;
    	int right = num;
    	long mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		if(num == mid * mid) {
    			return true;
    		}else if(num < mid * mid){
    			right = (int) (mid - 1);
    		}else if(num > mid * mid){
				left = (int) (mid + 1);
    		}
    	}
		return false;
    }
	
}
