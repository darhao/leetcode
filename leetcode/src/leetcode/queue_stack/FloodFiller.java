package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloodFiller {

	private int[][] grid;
	private Set<Point> visited;
	private int newColor;
	private int oldColor;
	
	
	class Point{
		private int row;
		private int col;
		
		public Point(int row, int col) {
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
	
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	visited = new HashSet<>();
        grid = image;
        oldColor = grid[sr][sc];
        this.newColor = newColor;
        Point point = new Point(sr, sc);
		fill(point);
		return grid;
    }
    
	
    private void fill(Point point) {
    	if(visited.contains(point)) {
    		return;
    	}
		visited.add(point);
		grid[point.getRow()][point.getCol()] = newColor;
		List<Point> neighbors = findNeighbors(point);
		for (Point neighbor : neighbors) {
			//只填充颜色值为oldColor的邻居
			if(grid[neighbor.getRow()][neighbor.getCol()] == oldColor) {
				fill(neighbor);
			}
		}
	}
    
    
	private List<Point> findNeighbors(Point point) {
		int currentRow = point.getRow();
		int currentCol = point.getCol();
		List<Point> neighbors = new ArrayList<>();
		//上
		Point neighbor = new Point(currentRow - 1, currentCol);
		addNeighbor(neighbors, neighbor);
		//左
		neighbor = new Point(currentRow, currentCol - 1);
		addNeighbor(neighbors, neighbor);
		//下
		neighbor = new Point(currentRow + 1, currentCol);
		addNeighbor(neighbors, neighbor);
		//右
		neighbor = new Point(currentRow, currentCol + 1);
		addNeighbor(neighbors, neighbor);
		return neighbors;
	}


	private void addNeighbor(List<Point> neighbors, Point neighbor) {
		if(neighbor.getRow() < 0 || neighbor.getCol() < 0 || neighbor.getRow() > grid.length - 1 || neighbor.getCol() > grid[0].length - 1) {
			return;
		}
		neighbors.add(neighbor);
	}
	
}
