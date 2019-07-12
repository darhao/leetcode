package leetcode.linklist;

import java.util.HashMap;
import java.util.Map;

public class RandomListCopier {
	
	static class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}

	
    public Node copyRandomList(Node head) {
    	Map<Node, Node> map = new HashMap<>();
    	//链表拷贝
    	Node newHead = null, preNode = null, curNode = null;
    	while(head != null) {
    		curNode = new Node(head.val, null, head.random);
    		map.put(head, curNode);//将新旧节点绑定在一起
    		if(preNode != null) {
    			preNode.next = curNode;
    		}
    		if(newHead == null) {
    			newHead = curNode;
    		}
    		preNode = curNode;
    		head = head.next;
    	}
    	//对随机指针进行赋值
    	curNode = newHead;
    	while(curNode != null) {
    		if(curNode.random != null) {
    			curNode.random = map.get(curNode.random);
    		}
    		curNode = curNode.next;
    	}
    	return newHead;
    }
    
    
    public static void main(String[] args) {
		Node n1 = new Node();
		Node n2 = new Node();
		n1.val = 1;
		n1.next = n2;
		n1.random = n2;
		n2.val = 2;
		n2.next = null;
		n2.random = n2;
		new RandomListCopier().copyRandomList(n1);
	}
	
}
