package leetcode.linklist;

import leetcode.linklist.PalindromeList.ListNode;

public class RotateList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLength(head);
        k = k % len;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        rotate(dummyHead, k);
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
	
	
	private void rotate(ListNode front, int k) {
		ListNode node = front.next;
		for (int i = 0; i < k; i++) {
			
		}
		while (node != null && node.next != null) {
			ListNode temp = node.next;
			node.next = node.next.next;
			temp.next = front.next;
			front.next = temp;
		}
	}
    
}
