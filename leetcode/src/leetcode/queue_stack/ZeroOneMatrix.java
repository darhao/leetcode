package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ZeroOneMatrix {

	class Room{
		private int row;
		private int col;
		
		public Room(int row, int col) {
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
	
	
	private int[][] rooms;
	
	
    public int[][] updateMatrix(int[][] matrix) {
    	this.rooms = matrix;
        for (Room room : find(matrix)) {
        	setMinDistance(room);
		}
        return matrix;
    }


	private List<Room> find(int[][] rooms) {
		List<Room> result = new ArrayList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if(rooms[i][j] != 0) { 
					result.add(new Room(i, j));
				}
			}
		}
		return result;
	}


	private void setMinDistance(Room room) {
		Set<Room> visitedRooms = new HashSet<>();
		Queue<Room> willVisitRooms = new LinkedList<>();
		willVisitRooms.offer(room);
		visitedRooms.add(room);
		int distance = 1;
		while(willVisitRooms.size() > 0) {
			int needVisitNum = willVisitRooms.size();
			while(needVisitNum > 0) {
				List<Room> notVisitNeighborRooms = findNotVisitNeighbor(visitedRooms, willVisitRooms.poll());
				for (Room neighbor : notVisitNeighborRooms) {
					if(rooms[neighbor.getRow()][neighbor.getCol()] == 0) {//到达0
						rooms[room.getRow()][room.getCol()] = distance;
						return;
					}else {
						willVisitRooms.offer(neighbor);					}
				}
				needVisitNum--;
			}
			distance++;
		}
	}


	private List<Room> findNotVisitNeighbor(Set<Room> visitedRooms, Room room) {
		int currentRow = room.getRow();
		int currentCol = room.getCol();
		List<Room> neighbors = new ArrayList<>();
		//���Ϸ�
		Room neighbor = new Room(currentRow - 1, currentCol);
		addNeighbor(visitedRooms, neighbors, neighbor);
		//����
		neighbor = new Room(currentRow, currentCol - 1);
		addNeighbor(visitedRooms, neighbors, neighbor);
		//���·�
		neighbor = new Room(currentRow + 1, currentCol);
		addNeighbor(visitedRooms, neighbors, neighbor);
		//���ҷ�
		neighbor = new Room(currentRow, currentCol + 1);
		addNeighbor(visitedRooms, neighbors, neighbor);
		return neighbors;
	}


	private void addNeighbor(Set<Room> visitedRooms, List<Room> neighbors, Room neighbor) {
		if(neighbor.getRow() < 0 || neighbor.getCol() < 0 || neighbor.getRow() > rooms.length - 1 || neighbor.getCol() > rooms[0].length - 1) {
			return;
		}
		if(visitedRooms.add(neighbor)) {
			neighbors.add(neighbor);
		}
	}
	
	
	public static void main(String[] args) {
		
		int[][] map = new int[][] {{0,1,1},{1,1,1},{1,1,1}};
		for (int[] row : new ZeroOneMatrix().updateMatrix(map)) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
}
