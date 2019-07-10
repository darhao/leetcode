package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumIslands {

	private char[][] grid;
	private Set<Island> visited;
	
	class Island{
		private int row;
		private int col;
		
		public Island(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}
		
		@Override
		public boolean equals(Object obj) {
			return hashCode() == obj.hashCode();
		}
		
		@Override
		public int hashCode() {
			return (row + "," + col).hashCode();
		}
	}
	
    public int numIslands(char[][] grid) {
    	visited = new HashSet<>();
    	int sum = 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1' && !visited.contains(new Island(i, j))) {
					sum++;
					visited.add(new Island(i, j));
					visitIsland(i, j);
				}
			}
		}
        return sum;
    }
    
    
    private void visitIsland(int row, int col) {
		Queue<Island> willVisit = new LinkedList<>();
		willVisit.add(new Island(row, col));
		while(willVisit.size() > 0) {
			Island island = willVisit.poll();
			List<Island> notVisitNeighborRooms = findNotVisitNeighbor(visited, island);
			for (Island neighbor : notVisitNeighborRooms) {
				willVisit.offer(neighbor);
			}
		}
	}
    
	private List<Island> findNotVisitNeighbor(Set<Island> visitedIsland, Island island) {
		int currentRow = island.getRow();
		int currentCol = island.getCol();
		List<Island> neighbors = new ArrayList<>();
		//上
		Island neighbor = new Island(currentRow - 1, currentCol);
		addNeighbor(visitedIsland, neighbors, neighbor);
		//左
		neighbor = new Island(currentRow, currentCol - 1);
		addNeighbor(visitedIsland, neighbors, neighbor);
		//下
		neighbor = new Island(currentRow + 1, currentCol);
		addNeighbor(visitedIsland, neighbors, neighbor);
		//右
		neighbor = new Island(currentRow, currentCol + 1);
		addNeighbor(visitedIsland, neighbors, neighbor);
		return neighbors;
	}


	private void addNeighbor(Set<Island> visitedIsland, List<Island> neighbors, Island neighbor) {
		if(neighbor.getRow() < 0 || neighbor.getCol() < 0 || neighbor.getRow() > grid.length - 1 || neighbor.getCol() > grid[0].length - 1) {
			return;
		}
		if(grid[neighbor.getRow()][neighbor.getCol()] == '1') {
			if(visitedIsland.add(neighbor)) {
				neighbors.add(neighbor);
			}
		}
	}
	
	
	public static void main(String[] args) {
//		char[][] map = new char[][] {{'0', '1'},{'0', '1'}};
//		char[][] map = new char[][] {{'1', '1'},{'0', '1'}};
		char[][] map = new char[][] {{'1', '0'},{'0', '1'}};
		System.out.println(new NumIslands().numIslands(map));
	}
	
}
