package leetcode.linklist;

public class RotateList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	private ListNode head;
	private int k;
	private int c;
	

    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null) {
    		return null;
    	}
    	this.head = head;
        int len = getLength(this.head);
        if(len == 1) {
        	return head;
        }
        this.k = k % len;
        ListNode cur = this.head;
        rotate(null, cur);
		return this.head;
    }
    
	
	private int getLength(ListNode headA) {
		int length = 0;
		ListNode node = headA;
		while(node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
	
	
	private void rotate(ListNode pre, ListNode cur) {
		if(cur.next == null) {
			return;
		}
		pre = cur;
		cur = cur.next;
		rotate(pre, cur);
		if(c < k) {
			c++;
			cur.next = head;
			head = cur;
			pre.next = null;	
		}
	}
	
	
	public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	new RotateList().rotateRight(n1, 2);
	}
    
}
