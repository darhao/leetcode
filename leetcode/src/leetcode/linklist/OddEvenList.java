package leetcode.linklist;

public class OddEvenList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode neck = head.next;
        ListNode first = head;
        ListNode second = head.next;
        while(first != null && first.next != null && second != null && second.next != null) {
        	first.next = first.next.next;
        	first = first.next;
        	second.next = second.next.next;
        	second = second.next;
        }
        first.next = neck;
        return head;
    }
	
}
