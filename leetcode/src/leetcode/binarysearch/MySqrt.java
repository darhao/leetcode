package leetcode.binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
    	int left = 0;
    	int right = x;
    	long mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		if(mid * mid == x) {
    			return (int) mid;
    		}else if(mid * mid > x){
    			right = (int) (mid - 1);
    		}else if(mid * mid < x){
    			if((mid + 1) * (mid + 1) > x) {
    				return (int) mid;
    			}
				left = (int) (mid + 1);
    		}
    	}
		return x;
    }
    
    
    public static void main(String[] args) {
//    	System.out.println(new MySqrt().mySqrt(0));
//    	System.out.println(new MySqrt().mySqrt(1));
//    	System.out.println(new MySqrt().mySqrt(2));
//		System.out.println(new MySqrt().mySqrt(4));
//		System.out.println(new MySqrt().mySqrt(8));
//		System.out.println(new MySqrt().mySqrt(16));
//		System.out.println(new MySqrt().mySqrt(81));
		System.out.println(new MySqrt().mySqrt(2147395599));
	}
    
}
