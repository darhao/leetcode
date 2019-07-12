package leetcode.linklist;

public class ListNodeDeleter {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) {
    		return head;
    	}
    	ListNode leader = head;
    	ListNode follower = head;
    	//�쵼����n��
    	for (int i = 0; i < n + 1; i++) {
    		if(leader == null) {
    			return head.next;
    		}
			leader = leader.next;	
		}
    	//ͬ��ǰ��ֱ���쵼��ĩβ
    	while (leader != null) {
			leader = leader.next;
			follower = follower.next;
		}
    	//ɾ��׷���ߴ��Ľڵ�
    	follower.next = follower.next.next;
    	return head;
    }
	
}
