package leetcode.tree.BST;

import leetcode.entity.TreeNode;

public class SearchTreeChecker {

	Integer lastNodeVal = null;
	boolean isValid = true;
	
    public boolean isValidBST(TreeNode root) {
    	helper(root);
    	return isValid;
    }
    
    
    public void helper(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	helper(node.left);
    	if(lastNodeVal != null && node.val <= lastNodeVal) {
    		isValid = false;
    	}
    	lastNodeVal = node.val;
    	helper(node.right);
    }
	
}
