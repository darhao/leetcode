package leetcode.linklist;

public class PalindromeList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	

    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null){
    		return true;
		}
        //求出长度
    	int len = getLength(head);
    	//取出中节点
    	int half = (len / 2) - 1 + (len % 2);
    	ListNode front = getNodeByIndex(head, half);
    	//翻转后半部分链表
    	reverse(front);
    	//检查是否回文
    	return checkPalindrome(head, front.next);
    }
	
    
    private boolean checkPalindrome(ListNode behind, ListNode front) {
    	while(front != null) {
    		if(behind.val != front.val) {
    			return false;
    		}
    		behind = behind.next;
    		front = front.next;
    	}
    	return true;
	}


	private void reverse(ListNode front) {
		ListNode node = front.next;
		while (node != null && node.next != null) {
			ListNode temp = node.next;
			node.next = node.next.next;
			temp.next = front.next;
			front.next = temp;
		}
	}


	private ListNode getNodeByIndex(ListNode head, int index) {
    	ListNode node = head;
    	for (int i = 0; i < index; i++) {
			node = node.next;
		}
    	return node;
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
	
	
	public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(1);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
		new PalindromeList().isPalindrome(n1);
	}
}
