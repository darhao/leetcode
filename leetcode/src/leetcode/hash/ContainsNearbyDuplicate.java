package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			if(lastIndexMap.containsKey(nums[i])) {
				if(i - lastIndexMap.get(nums[i]) <= k) {
					return true;
				}
			}
			//更新最后一次元素出现的索引位置
			lastIndexMap.put(nums[i], i);
		}
        return false;
    }
	
}
