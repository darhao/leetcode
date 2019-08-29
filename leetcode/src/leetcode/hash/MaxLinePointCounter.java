package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxLinePointCounter {

    public int maxPoints(int[][] points) {
    	//2个点以下，结果就一定是点的个数
    	if(points.length < 2) {
    		return points.length;
    	}
    	
    	Map<Integer, Map<Integer, Set<Integer>>> oLineMap = new HashMap<>();//最简斜率分数哈希值、该直线中某一点的索引值 <=> 点的索引值
    	Map<Integer, Set<Integer>> vhLineMap = new HashMap<>();//水平线或垂直线和对应的y或x合起来的哈希值 <=> 点的索引值
    	//两两成线，并记录
    	for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if(points[i] == points[j]) {
					continue;
				}
				//计算y差值，和x差值
				int x1 = points[i][0], x2 = points[j][0], y1 = points[i][1], y2 = points[j][1];
				int dy = y1 - y2;
				int dx = x1 - x2;
				String[] key = null;
				if(dx == 0 || dy == 0) {//纵横线
					if(dx == 0) {//垂直线或重合点
						key = new String[] {"|", x1+""};
					}else if(dy == 0) {//水平线
						key = new String[] {"-", y1+""};
					}
					int keyHash = Arrays.hashCode(key);
					Set<Integer> set = vhLineMap.getOrDefault(keyHash, new HashSet<>());
					set.add(j);
					vhLineMap.put(keyHash, set);
				}else {//斜线
					key = reductionOfFraction(dy, dx);
					int keyHash = Arrays.hashCode(key);
					Map<Integer, Set<Integer>> pointMap = oLineMap.get(keyHash);
					if(pointMap == null) {//如果最简k对应的基准点不存在，就把当前的任意点的索引当成基准点存入
						pointMap = new HashMap<>();
						pointMap.put(j, new HashSet<>());
					}
					for (Integer pointIndex : pointMap.keySet()) {
						//计算y差值，和x差值
						int[] point = points[pointIndex];
						int x3 = point[0], y3 = point[1];
						int dy2 = y2 - y3, dx2 = x2 - x3;
						if(dy2 == 0 && dx2 == 0) {
							pointMap.get(pointIndex).add(j);
							break;
						}
						if(dy2 == 0 || dx2 == 0) {
							continue;
						}
						String[] key2 = reductionOfFraction(dy2 , dx2);
						if(Arrays.hashCode(key2) == keyHash) {
							pointMap.get(pointIndex).add(j);
							break;
						}
					}
					oLineMap.put(keyHash, pointMap);
				}
			}
		}
    	
    	//统计最大值
    	int max = 0;
    	for (Integer keyHash : vhLineMap.keySet()) {
			int count = vhLineMap.get(keyHash).size();
			if(count > max) {
				max = count;
			}
		}
    	for (Integer keyHash : oLineMap.keySet()) {
    		for (Integer pointIndex : oLineMap.get(keyHash).keySet()) {
    			int count = oLineMap.get(keyHash).get(pointIndex).size();
    			if(count > max) {
    				max = count;
    			}
			}
		}
    	
    	return max;
    }
    
    
    private String[] reductionOfFraction(int dy, int dx) {
    	int a = dy, b = dx;
    	//求最大共因素:辗转相除法
    	int maxCommonFactors = 1;
    	int c;
		do {
	    	c = a % b;
	    	if(c == 0) {
	    		maxCommonFactors = b;
	    	}else {
	    		a = b;
	    		b = c;
	    	}
    	}while(c != 0);
		//约分
		String[] result = new String[] {(dy / maxCommonFactors) + "", (dx / maxCommonFactors) + ""};
		return result;
    }
    
    
    
    public static void main(String[] args) {
		System.out.println(new MaxLinePointCounter().maxPoints(new int[][]{new int[]{2,3}, new int[]{3,3}, new int[]{-1,3}}));//3
		System.out.println(new MaxLinePointCounter().maxPoints(new int[][]{new int[]{1,1}, new int[]{1,1}, new int[]{2,3}}));//3
		System.out.println(new MaxLinePointCounter().maxPoints(new int[][]{new int[]{0,0}, new int[]{0,1}}));//2
		System.out.println(new MaxLinePointCounter().maxPoints(new int[][]{new int[]{0,0}, new int[]{94911151,94911150}, new int[]{94911152,94911151}}));//2
		System.out.println(new MaxLinePointCounter().maxPoints(new int[][]{new int[]{1,1}, new int[]{1,1}, new int[]{2,2}, new int[]{2,2}}));//4
    }
	
}
