package leetcode.tree.BST;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeSet<Integer> set = new TreeSet<>();
    	for (int i = 0; i < nums.length; i++) {
    		//获取当前值
    		Long cur = (long) nums[i];
    		
    		//获取比当前值大的最小值
    		Integer ceiling = set.ceiling(cur.intValue());
			//判断是否存在并且是否与当前值差距不超过t
    		if(ceiling != null && ceiling.longValue() - cur <= t) {
				return true;
			}
			
    		//获取比当前值小的最大值
    		Integer floor = set.floor(cur.intValue());
			//判断是否存在并且是否与当前值差距不超过t
    		if(floor != null && cur - floor.longValue() <= t) {
				return true;
			}
				
			//把元素加入树
			set.add(cur.intValue());
			
			//如果树的大于k，就移除最先加入的元素，以维持一个大小为k的滑动窗口
			if(set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
    	return false;
    }
	
}
