package leetcode.linklist;

public class FlattenList {

	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}
	
	
    public Node flatten(Node head) {
    	Node cur = head;
    	while(cur != null) {
    		if(cur.child != null) {
    			Node temp = cur.next;
    			cur.next = flatten(cur.child);
    			cur.child.prev = cur;
    			cur.child = null;
    			while(cur.next != null) {
    				cur = cur.next;
    			}
    			cur.next = temp;
    			if(temp != null) {
    				temp.prev = cur;
    			}
    		}
    		cur = cur.next;
    	}
    	return head;
    }
	
}
