package leetcode.tree.BST;

import leetcode.entity.TreeNode;

public class BSTInserter {
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
    	if(root.val > val) {
    		if(root.left != null) {
    			insertIntoBST(root.left, val);
    		}else {
    			root.left = new TreeNode(val);
    		}
    	}else {
    		if(root.right != null) {
    			insertIntoBST(root.right, val);
    		}else {
    			root.right = new TreeNode(val);
    		}
    	}
    	return root;
    }
    
}
