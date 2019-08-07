package leetcode.tree.binarytree;

public class NotPrefectConnect {

	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	
    public Node connect(Node root) {
    	if(root == null || (root.left == null && root.right == null)) {
    		return root;
		}
    	if(root.left != null && root.right != null) {
    		root.left.next = root.right;
    	}
    	if(root.next != null) {
    		Node node1 = root.right != null ? root.right : root.left;
			Node node2 = null;
			Node cur = root.next;
			while(cur != null) {
				if(cur.left == null && cur.right == null) {
					cur = cur.next;
				}else {
					node2 = cur.left != null ? cur.left : cur.right;
					break;
				}
			}
			node1.next = node2;
    	}
    	connect(root.right);
		connect(root.left);
		return root;
    }
    
    
    public static void main(String[] args) {
		Node n7 = new Node(7,null,null,null);
		Node n6 = new Node(6,null,null,null);
		Node n5 = new Node(5,null,null,null);
		Node n4 = new Node(4,null,null,null);
		Node n3 = new Node(3,n6,n7,null);
		Node n2 = new Node(2,n4,n5,null);
		Node n1 = new Node(1,n2,n3,null);
		new NotPrefectConnect().connect(n1);
	}
	
}
