package leetcode.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BoomerangsCounter {

    public int numberOfBoomerangs(int[][] points) {
        List<Map<Integer, Integer>> set = new LinkedList<>();
    	for (int i = 0; i < points.length; i++) {
    		Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if(i == j) {
					continue;
				}
				int pointAx = points[i][0];
				int pointBx = points[j][0];
				int pointAy = points[i][1];
				int pointBy = points[j][1];
				int distance = (int) (Math.pow(Math.abs(pointAx - pointBx), 2) + Math.pow(Math.abs(pointAy - pointBy), 2));
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			set.add(map);
		}
    	
    	int sum = 0;
    	for (Map<Integer, Integer> map : set) {
			for (Integer distance : map.keySet()) {
				int count = map.get(distance);
				sum += (Math.pow(count, 2) - count);
			}
		}
    	
    	return sum;
    }
	
    
    public static void main(String[] args) {
		System.out.println(new BoomerangsCounter().numberOfBoomerangs(new int[][]{new int[] {0,0}, new int[] {1,0}, new int[] {0,1}, new int[] {-1,0}, new int[] {0,-1}}));
	}
}
