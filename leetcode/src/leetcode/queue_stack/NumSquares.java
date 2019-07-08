package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumSquares {
	
    public int numSquares(int n) {
    	return bfs(getSquares(n), n);
    }
    
    
    private int bfs(List<Integer> squares, int n) {
    	int numsOfSquare = 1;
		Queue<Integer> willVisit = new LinkedList<>();
		willVisit.addAll(squares);
		while(willVisit.size() > 0) {
			Set<Integer> visited = new HashSet<>();
			int needVisitNum = willVisit.size();
			while(needVisitNum > 0) {
				Integer square = willVisit.poll();
				if(square == n) {
					return numsOfSquare;
				}
				for (Integer square2 : squares) {
					if(!visited.contains(square + square2)) {
						willVisit.offer(square + square2);
						visited.add(square + square2);
					}
				}
				needVisitNum--;
			}
			numsOfSquare++;
		}
		return -1;
	}


	private List<Integer> getSquares(int n) {
		List<Integer> squares = new ArrayList<>();
    	for (int square = 1; square <= n; square++) {
    		double root = Math.sqrt(square * 1.0);
    		if(root - Math.floor(root) == 0) {
    			squares.add(square);
    		}
		}
    	return squares;
	}
    
    
    public static void main(String[] args) {
    	long a = System.currentTimeMillis();
    	System.out.println(new NumSquares().numSquares(117298));
//		new NumSquares().numSquares(1000000);
		System.out.println("耗时：" + (System.currentTimeMillis() - a));
	}
	
}
