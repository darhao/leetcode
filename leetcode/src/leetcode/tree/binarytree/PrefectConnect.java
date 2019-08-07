package leetcode.tree.binarytree;

public class PrefectConnect {

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
    	if(root == null || root.left == null) {
    		return root;	
		}
		root.left.next = root.right;
		if(root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
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
		new PrefectConnect().connect(n1);
	}
	
}
