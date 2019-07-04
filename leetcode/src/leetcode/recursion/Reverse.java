package leetcode.recursion;

public class Reverse {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}else {
			return recursion(null, head);
		}
    }

	private ListNode recursion(ListNode last, ListNode now) {
		if(now.next == null) {
			now.next = last;
			return now;
		}else {
			ListNode newHead = recursion(now, now.next);
			now.next = last;
			return newHead;
		}
	}
	
	public static void main(String[] args) {
		ListNode a  = new ListNode(1);
		ListNode b  = new ListNode(2);
		ListNode c  = new ListNode(3);
		a.next = b;
		b.next = c;
		new Reverse().reverseList(a);
	}
	
}
