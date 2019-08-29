package leetcode.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSumFinder {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums.length < 3) {
    		return new LinkedList<>();
    	}
        List<Integer> sortList = new ArrayList<Integer>();
        Set<String> repeatSet = new HashSet<>();
        for (int integer : nums) {
			sortList.add(integer);
		}
        Collections.sort(sortList);
        //如果全是负数或整数则无结果
        if(sortList.get(0) > 0 || sortList.get(sortList.size() - 1) < 0) {
        	return new LinkedList<>();
        }
        //如果全是零就直接返回000
        if(sortList.get(0) == 0 && sortList.get(sortList.size() - 1) == 0) {
        	List<Integer> result = new LinkedList<>();
        	result.add(0);
        	result.add(0);
        	result.add(0);
        	List<List<Integer>> ll = new LinkedList<>();
        	ll.add(result);
        	return ll;
        }
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 1; i < sortList.size() - 1; i++) {
        	int left = 0, right = nums.length - 1;
        	while(true) {
        		//相遇跳出
        		if(left == i || i == right) {
        			break;
        		}
        		//同符号跳出
        		if(sortList.get(left) > 0 || sortList.get(right) < 0) {
        			break;
        		}
        		int sum = sortList.get(i) + sortList.get(left) + sortList.get(right);
    			if(sum == 0) {
    				List<Integer> result = new LinkedList<>();
    				result.add(sortList.get(i));
    				result.add(sortList.get(left));
    				result.add(sortList.get(right));
    				StringBuffer sb = new StringBuffer();
    				sb.append(sortList.get(left)).append(",").append(sortList.get(i)).append(",").append(sortList.get(right));
    				if(!repeatSet.contains(sb.toString())) {
    					repeatSet.add(sb.toString());
        				results.add(result);
    				}
    				left++;
    			}else if(sum > 0){
    				right--;
    			}else {
    				left++;
    			}
        	}
		}
        return results;
    }
    
    
    public static void main(String[] args) {
    	long a = System.currentTimeMillis();
    	List<List<Integer>> list = new ThreeSumFinder().threeSum(new int[] {0,-4,2,-1,-1,1});
		System.out.println("耗时" + (System.currentTimeMillis() - a));
		for (List<Integer> ii : list) {
			for (Integer integer : ii) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
    }
	
}
