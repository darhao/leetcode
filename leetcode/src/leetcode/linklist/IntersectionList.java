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
    	//��ȡ����
    	int lengthA = getLength(headA);
    	int lengthB = getLength(headB);
    	//�Ƚϳ��ȣ�����ָ�����ƶ� |lengthA - lengthB| ��
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
    	//��ʼͬʱ�ƶ�
    	while(a != null) {
    		//����
    		if(a == b) {
    			return a;
    		}
    		a = a.next;
    		b = b.next;
    	}
    	//�޷�����
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
