package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCounter {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	//ƽ���ռ临�Ӷ�O(n)
        Map<Integer, Integer> abSumMap = new HashMap<>();//AB�ĺ� �� �ͳ��ֵĴ��� ֮ӳ��
        Map<Integer, Integer> cdSumMap = new HashMap<>();//CD�ĺ� �� �ͳ��ֵĴ��� ֮ӳ��
        //��������ӳ�䣬ʱ�临�Ӷ�O(n^2)
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
        //��������������Ԫ����
        int sum = 0;
        for (Integer abSum : abSumMap.keySet()) {
        	sum += abSumMap.get(abSum) * cdSumMap.getOrDefault(-abSum, 0);
		}
        return sum;
    }
	
}
