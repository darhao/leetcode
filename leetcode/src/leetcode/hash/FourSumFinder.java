package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSumFinder {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				List<int[]> list = map.getOrDefault(nums[i] + nums[j], new LinkedList<>());
				list.add(new int[] {i,j});
				map.put(nums[i] + nums[j], list);
			}
		}
        
        Set<Integer> repeatSet = new HashSet<>();
        Map<Integer, int[]> res = new HashMap<>();
        for (int key : map.keySet()) {
			if(repeatSet.contains(key)) {
				continue;
			}
			int key2 = target - key;
			repeatSet.add(key2);
			List<int[]> list1 = map.getOrDefault(key, new LinkedList<>());
			List<int[]> list2 = map.getOrDefault(key2, new LinkedList<>());
			for (int[] i1 : list1) {
				for (int[] i2 : list2) {
					if(i1[0] == i2[0] || i1[0] == i2[1] || i1[1] == i2[0] || i1[1] == i2[1]) {
						continue;
					}
					int[] aa = new int[] {nums[i1[0]],nums[i1[1]],nums[i2[0]],nums[i2[1]]};
					Arrays.sort(aa);
					res.put(Arrays.hashCode(aa), aa);
				}
			}
		}
        
        List<List<Integer>> result = new LinkedList<>();
        for (int[] ii : res.values()) {
        	List<Integer> ll = Arrays.asList(ii[0], ii[1], ii[2], ii[3]);
        	result.add(ll);
		}
        
        return result;
    }
    
    
    public static void main(String[] args) {
		for (List<Integer> ll : new FourSumFinder().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 1)) {
			for (Integer integer : ll) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
}
