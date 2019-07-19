package leetcode.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectArray {
	
    public int[] intersect(int[] nums1, int[] nums2) {
        //计算出两个数组的每个元素的个数
    	Map<Integer, Integer> map1 = new HashMap<>();
    	Map<Integer, Integer> map2 = new HashMap<>();
    	for (int i : nums1) {
			if(map1.containsKey(i)) {
				map1.put(i, map1.get(i)+ 1);
			}else {
				map1.put(i, 1);
			}
		}
    	for (int i : nums2) {
			if(map2.containsKey(i)) {
				map2.put(i, map2.get(i)+ 1);
			}else {
				map2.put(i, 1);
			}
		}
    	//匹配相同的元素并且取个数少的那个元素作为最终数组的元素之一
    	Map<Integer, Integer> map3 = new HashMap<>();
    	for (int i : map1.keySet()) {
			if(map2.containsKey(i)) {
				if(map1.get(i).intValue() <= map2.get(i).intValue()) {
					map3.put(i, map1.get(i));
				}else {
					map3.put(i, map2.get(i));
				}
			}
		}
    	//计算返回值
    	List<Integer> list = new LinkedList<>();
    	for (int i : map3.keySet()) {
			for (int j = 0; j < map3.get(i); j++) {
				list.add(i);
			}
		}
    	int[] result = new int[list.size()];
    	for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
    	return result;
    }
}
