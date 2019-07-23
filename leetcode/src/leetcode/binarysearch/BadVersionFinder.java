package leetcode.binarysearch;

public class BadVersionFinder {

	private int firistBadVersion;
	
	public BadVersionFinder(int firstBadVersion) {
		this.firistBadVersion = firstBadVersion;
	}
	
	
    public int firstBadVersion(int n) {
    	int left = 1, right = n, mid = -1;
    	while(left < right){
    		mid = left + (right - left) / 2;
    		if(isBadVersion(mid)) {
    			right = mid;
    		}else {
    			left = mid + 1;
    		}
    	}
    	return isBadVersion(left) ? left : -1;
    }
    
    
    private boolean isBadVersion(int version) {
    	return version >= firistBadVersion;
    }
    
	
}
