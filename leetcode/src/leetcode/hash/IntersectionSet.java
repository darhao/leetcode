package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSet {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<>();
    	for (Integer integer : nums1) {
			set1.add(integer);
		}
    	Set<Integer> set2 = new HashSet<>();
    	for (Integer integer : nums2) {
			set2.add(integer);
		}
    	Set<Integer> result = new HashSet<>();
    	for (Integer integer : set1) {
			for (Integer integer2 : set2) {
				if(integer.equals(integer2)) {
					result.add(integer);
					break;
				}
			}
		}
    	int[] resultArray = new int[result.size()];
    	int index = 0;
    	for (int i : result) {
			resultArray[index] = i;
			index++;
		}
    	return resultArray;
    }
	
}
