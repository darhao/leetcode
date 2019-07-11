package leetcode.linklist;

public class CycleList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	private ListNode slow;
	private ListNode fast;
	
	
    public boolean hasCycle(ListNode head) {
    	slow = fast = head;
    	try {
			while(true) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) {
					return true;
				}
			}
		} catch (NullPointerException e) {
			return false;
		}
    }
	
}
