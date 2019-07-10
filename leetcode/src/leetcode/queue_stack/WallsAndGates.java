package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

	final static int INF = 2147483647;
	
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
	
	
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        List<Room> doors = findDoors(rooms);
        setMinDistance(doors);
    }


	private List<Room> findDoors(int[][] rooms) {
		List<Room> doors = new ArrayList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if(rooms[i][j] == 0) { 
					doors.add(new Room(i, j));
				}
			}
		}
		return doors;
	}


	private void setMinDistance(List<Room> doors) {
		Set<Room> visitedRooms = new HashSet<>();
		Queue<Room> willVisitRooms = new LinkedList<>();
		int distance = 1;
		for (Room door : doors) {
			willVisitRooms.add(door);
		}
		while(willVisitRooms.size() > 0) {
			int needVisitNum = willVisitRooms.size();
			while(needVisitNum > 0) {
				Room room = willVisitRooms.poll();
				List<Room> notVisitNeighborRooms = findNotVisitNeighbor(visitedRooms, room);
				for (Room neighbor : notVisitNeighborRooms) {
					if(rooms[neighbor.getRow()][neighbor.getCol()] == INF) {
						//���뵱ǰ����
						rooms[neighbor.getRow()][neighbor.getCol()] = distance;
						willVisitRooms.offer(neighbor);
					}
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
		visitedRooms.add(neighbor);
		neighbors.add(neighbor);
	}
	
	
	public static void main(String[] args) {
		
//		int[][] map = new int[][] {{INF, -1},{INF, 0}};
//		int[][] map = new int[][] {{INF, 0},{INF, 0}};
//		int[][] map = new int[][] {{INF, 0}};
//		int[][] map = new int[][] {{0}};
//		int[][] map = new int[][] {{-1}};
//		int[][] map = new int[][] {{INF}};
//		int[][] map = new int[][] {{INF, -1 , 0}};
		int[][] map = new int[][] {{INF, -1 ,0}, {INF, INF, INF}};
		new WallsAndGates().wallsAndGates(map);
		for (int[] row : map) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
}
