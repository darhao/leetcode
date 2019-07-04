package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

	Map<Integer, Integer> cache = new HashMap<>();
	
	public int climbStairs(int n) {
		return climbStairs(0, n);
	}
	
	private int climbStairs(int currentLevel, int sumLevels) {
		if(cache.containsKey(currentLevel)) {
			return cache.get(currentLevel);
		}
		if(currentLevel > sumLevels) {
			return 0;
		}else if(currentLevel == sumLevels) {
			return 1;
		}else {
			int result = climbStairs(currentLevel + 1, sumLevels) + climbStairs(currentLevel + 2, sumLevels);
			cache.put(currentLevel, result);
			return result;
		}
	}

    public static void main(String[] args) {
    	Double a = (double) System.nanoTime();	
    	new ClimbStairs().climbStairs(37);
		System.out.println("��ʱ��" + (System.nanoTime() - a) / (1000*1000) + "ms");
	}
	
}
