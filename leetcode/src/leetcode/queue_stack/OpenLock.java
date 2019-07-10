package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	private String[] deadends;
	private String currentPassword;
	private String target;
	
    public int openLock(String[] deadends, String target) {
        this.deadends = deadends;
        this.target = target;
        this.currentPassword = "0000";
        return bfs();
    }
    

	private int bfs() {
		Set<String> visited = new HashSet<>();
		Queue<String> willVisit = new LinkedList<>();
		int step = 0;
		willVisit.add(currentPassword);
		while(willVisit.size() > 0) {
			int needVisitNum = willVisit.size();
			while(needVisitNum > 0) {
				String password = willVisit.poll();
				//非死路
				if(!isDeadEnd(password)) {
					//找到目标
					if(password.equals(target)) {
						return step;
					}
					//列出其他方案
					List<String> notVisitNeighborPasswords = findNotVisitNeighbor(visited, password);
					for (String neighbor : notVisitNeighborPasswords) {
						willVisit.offer(neighbor);
					}
				}
				
				needVisitNum--;
			}
			step++;
		}
		return -1;
	}


	private boolean isDeadEnd(String password) {
		for (String deadends : deadends) {
			if(password.equals(deadends)) {
				return true;
			}
		}
		return false;
	}


	private List<String> findNotVisitNeighbor(Set<String> visited, String password) {
		List<String> neighbors = new ArrayList<>();
		//左1-
		String neighbor = ((Integer.parseInt(password.substring(0, 1)) + 10 - 1) % 10) + password.substring(1, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左1+
		neighbor = ((Integer.parseInt(password.substring(0, 1)) + 10 + 1) % 10) + password.substring(1, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左2-
		neighbor = password.substring(0, 1) + ((Integer.parseInt(password.substring(1, 2)) + 10 - 1) % 10) + password.substring(2, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左2+
		neighbor = password.substring(0, 1) + ((Integer.parseInt(password.substring(1, 2)) + 10 + 1) % 10) + password.substring(2, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左3-
		neighbor = password.substring(0, 2) + ((Integer.parseInt(password.substring(2, 3)) + 10 - 1) % 10) + password.substring(3, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左3+
		neighbor = password.substring(0, 2) + ((Integer.parseInt(password.substring(2, 3)) + 10 + 1) % 10) + password.substring(3, 4);
		addNeighbor(visited, neighbors, neighbor);
		//左4-
		neighbor = password.substring(0, 3) + ((Integer.parseInt(password.substring(3, 4)) + 10 - 1) % 10);
		addNeighbor(visited, neighbors, neighbor);
		//左4+
		neighbor = password.substring(0, 3) + ((Integer.parseInt(password.substring(3, 4)) + 10 + 1) % 10);
		addNeighbor(visited, neighbors, neighbor);
		return neighbors;
	}


	private void addNeighbor(Set<String> visited, List<String> neighbors, String neighbor) {
		if(visited.add(neighbor)) {//添加成功才算邻居
			neighbors.add(neighbor);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new OpenLock().openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
		System.out.println(new OpenLock().openLock(new String[] {"0201"}, "0009"));
		System.out.println(new OpenLock().openLock(new String[] {"5554"}, "5555"));
	}
	
}
