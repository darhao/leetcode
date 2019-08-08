package leetcode.tree.BST;

import leetcode.entity.TreeNode;

public class BSTDeleter {
	
	private TreeNode nextParNode;
	private boolean nextIsLeft;
	private TreeNode nextNode;
	private boolean isFoundNextNode;
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	TreeNode dumbRoot = new TreeNode(0);
    	dumbRoot.left = root;
    	helper(dumbRoot, true, root, key);
    	return dumbRoot.left;
    }
    
    
    public void helper(TreeNode parNode, boolean isLeft, TreeNode curNode, int key) {
    	if(curNode == null) {
    		return;
    	}
    	
    	if(curNode.val == key) {
    		TreeNode newBreakPoint = null; //如果目前节点没有子节点，就直接让父节点将其遗弃
    		if(curNode.left != null && curNode.right == null) { //如果目前节点有一个子节点，就直接让父节点与子节点连接
    			newBreakPoint = curNode.left;
    		}else if(curNode.left == null && curNode.right != null) { //如果目前节点有一个子节点，就直接让父节点与子节点连接
    			newBreakPoint = curNode.right;
    		}else if(curNode.left != null && curNode.right != null) { //如果目前节点有二个子节点，令目前节点与中序后继节点互换，后删除目前节点
    			inorder(null, isLeft, curNode, key); //找到目前节点的中序遍历后继节点及后继节点的父节点
    			//分两种情况
    			//（一、后继节点是目前节点的右节点）
    			if(curNode.right == nextNode) {
    				//1、目前节点的左节点赋值给后继节点的左节点（此后继节点的左节点必为空）
    				nextNode.left = curNode.left;
    				//2、目前节点的父节点的指定方向的子节点改成后继节点
        			newBreakPoint = nextNode;
    			}else {//（二、后继节点不是目前节点的右节点）
    				//1、存储后继节点的全部子节点
        			TreeNode tempL = nextNode.left;
        			TreeNode tempR = nextNode.right;
        			//2、目前节点的父节点的指定方向的子节点改成后继节点
        			newBreakPoint = nextNode;
        			//3、后继节点的子节点全部变成目前节点的子节点
        			nextNode.left = curNode.left;
        			nextNode.right = curNode.right;
        			//4、后继节点的父节点的指定方向的子节点改成后继节点的子节点中的一个（必有一不空）
        			if(nextIsLeft) {
        				nextParNode.left = tempL != null ? tempL : tempR;
        			}else {
        				nextParNode.right = tempL != null ? tempL : tempR;
        			}
    			}
    		}
			if(isLeft) {
				parNode.left = newBreakPoint;
			}else {
				parNode.right = newBreakPoint;
			}
    	}else if(curNode.val > key) {
    		helper(curNode, true, curNode.left, key);
    	}else {
    		helper(curNode, false, curNode.right, key);
    	}
    }
    
    
    public void inorder(TreeNode parNode, boolean isLeft, TreeNode curNode, int key) {
    	if(curNode == null) {
    		return;
    	}
    	inorder(curNode, true, curNode.left, key);
    	if(isFoundNextNode) {
    		nextNode = curNode;
    		nextParNode = parNode;
    		nextIsLeft = isLeft;
    		isFoundNextNode = false;
    	}
    	if(curNode.val == key) {
    		isFoundNextNode = true;
    	}
    	inorder(curNode, false, curNode.right, key);
    }
    
    
    public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n5.left = n3;
		n5.right = n6;
		n3.left = n2;
		n3.right = n4;
		n6.right = n7;
		new BSTDeleter().deleteNode(n5, 3);
	}
    
}
