package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> squareSumSet = new HashSet<>();
        while(true) {
        	int squareSum = 0;
        	while(n > 9) {
            	squareSum += (n % 10) * (n % 10);
            	n /= 10;
            }
            squareSum += n * n;
            if(squareSum == 1) {
            	return true;
            }
            if(squareSumSet.contains(squareSum)) {
            	return false;
            }
            squareSumSet.add(squareSum);
            n = squareSum;
        }
    }
    
    
    public static void main(String[] args) {
		new HappyNumber().isHappy(19);
	}
	
}
