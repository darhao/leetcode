package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCounter {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	//平均空间复杂度O(n)
        Map<Integer, Integer> abSumMap = new HashMap<>();//AB的和 与 和出现的次数 之映射
        Map<Integer, Integer> cdSumMap = new HashMap<>();//CD的和 与 和出现的次数 之映射
        //计算两个映射，时间复杂度O(n^2)
        for (Integer a : A) {
        	for (Integer b : B) {
    			abSumMap.put(a + b, abSumMap.getOrDefault((a + b), 0) + 1);
    		}
		}
        for (Integer c : C) {
        	for (Integer d : D) {
    			cdSumMap.put(c + d, cdSumMap.getOrDefault((c + d), 0) + 1);
    		}
		}
        //计算满足条件的元组数
        int sum = 0;
        for (Integer abSum : abSumMap.keySet()) {
        	sum += abSumMap.get(abSum) * cdSumMap.getOrDefault(-abSum, 0);
		}
        return sum;
    }
	
}
