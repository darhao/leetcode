package leetcode.linklist;

public class IntersectionList {
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
    		return null;
    	}
    	//获取长度
    	int lengthA = getLength(headA);
    	int lengthB = getLength(headB);
    	//比较长度，长者指针先移动 |lengthA - lengthB| 次
    	ListNode a = headA;
    	ListNode b = headB;
    	if(lengthA >= lengthB) {
    		for (int i = 0; i < lengthA - lengthB; i++) {
				a = a.next;
			}
    	}else {
    		for (int i = 0; i < lengthB - lengthA; i++) {
    			b = b.next;
			}
    	}
    	//开始同时移动
    	while(a != null) {
    		//相遇
    		if(a == b) {
    			return a;
    		}
    		a = a.next;
    		b = b.next;
    	}
    	//无法相遇
    	return null;
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
	
}
