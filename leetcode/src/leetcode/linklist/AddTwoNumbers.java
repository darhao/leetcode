package leetcode.linklist;

public class AddTwoNumbers {
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
    	int carry = 0;
    	ListNode cur = dummyHead;
    	while(l1 != null || l2 != null) {
    		int sum = 0;
    		if(l1 == null) {
    			sum = (l2.val + carry) % 10;
        		carry = (l2.val + carry) / 10;
        		l2 = l2.next;
    		}else if(l2 == null) {
    			sum = (l1.val + carry) % 10;
        		carry = (l1.val + carry) / 10;
        		l1 = l1.next;
    		}else {
    			sum = (l1.val + l2.val + carry) % 10;
        		carry = (l1.val + l2.val + carry) / 10;
        		l1 = l1.next;
        		l2 = l2.next;
    		}
    		cur.next = new ListNode(sum);
    		cur = cur.next;
    	}
    	if(carry == 1) {
    		cur.next = new ListNode(1);
    	}
    	return dummyHead.next;
    }
	
}
