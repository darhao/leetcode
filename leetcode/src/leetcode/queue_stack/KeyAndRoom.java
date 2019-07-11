package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyAndRoom {

	private Set<Integer> visited = new HashSet<>();
	private List<List<Integer>> rooms;
	
	
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	this.rooms = rooms;
    	visit(0);
    	return isVisitedAllRomms(rooms);
    }


	private void visit(int room) {
		if(visited.contains(room)) {
			return;
		}
		visited.add(room);
		List<Integer> keys = rooms.get(room);
		for (Integer key : keys) {
			visit(key);
		}
	}


	private boolean isVisitedAllRomms(List<List<Integer>> rooms) {
		for (int i = 0; i < rooms.size(); i++) {
			if(!visited.contains(i)) {
				return false;
			}
		}
    	return true;
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> rooms;
		rooms = new ArrayList<>();
		List<Integer> keys;
		keys = new ArrayList<>();
		keys.add(1);
		keys.add(3);
		rooms.add(keys);
		keys = new ArrayList<>();
		keys.add(3);
		keys.add(0);
		keys.add(1);
		rooms.add(keys);
		keys = new ArrayList<>();
		keys.add(2);
		rooms.add(keys);
		keys = new ArrayList<>();
		keys.add(0);
		rooms.add(keys);
		System.out.println(new KeyAndRoom().canVisitAllRooms(rooms));
		
		rooms = new ArrayList<>();
		keys = new ArrayList<>();
		keys.add(1);
		rooms.add(keys);
		keys = new ArrayList<>();
		keys.add(2);
		rooms.add(keys);
		keys = new ArrayList<>();
		keys.add(3);
		rooms.add(keys);
		keys = new ArrayList<>();
		rooms.add(keys);
		System.out.println(new KeyAndRoom().canVisitAllRooms(rooms));
	}
	
}
