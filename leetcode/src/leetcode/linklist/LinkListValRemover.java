package leetcode.linklist;

public class LinkListValRemover {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
        	return null;
        }
        //头部处理
        while(head.val == val) {
    		head = head.next;
    		if(head == null) {
    			return null;
    		}
        }
        //身体处理
        ListNode node = head;
        while(node.next != null) {
        	if(node.next.val == val) {
        		node.next = node.next.next;
        	}else {
        		node = node.next;
        	}
        }
        return head;
    }
    
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(1);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
		new LinkListValRemover().removeElements(n1, 2);
	}
	
}
