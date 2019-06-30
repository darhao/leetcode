package leetcode;

public class MergeOrderList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode mergeHead = new ListNode(0);
		merge(mergeHead, l1, l2);
		return mergeHead.next;
    }

	private void merge(ListNode head, ListNode l1, ListNode l2) {
		if((l1 != null && l2 != null && l1.val <= l2.val) || (l1 != null && l2 == null)) {
			head.next = l1;
			l1 = l1.next;
		}else if((l1 != null && l2 != null && l1.val > l2.val) || (l1 == null && l2 != null)) {
			head.next = l2;
			l2 = l2.next;
		}else {
			return;
		}
		merge(head.next, l1, l2);
	}
	
}
