package leetcode.linklist;

import java.util.HashSet;

public class CycleListII {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	private HashSet<ListNode> visited = new HashSet<>();
	
	
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
        	return null;
        }
    	while(head != null) {
    		if(visited.contains(head)) {
    			return head;
    		}
    		visited.add(head);
    		head = head.next;
    	}
    	return null;
    }
	
}
