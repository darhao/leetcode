package leetcode.tree.binarytree;

import leetcode.entity.TreeNode;

public class PathSumChecker {

	boolean hasPath = false;
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) {
    		return false;
    	}
        helper(root, 0, sum);
        return hasPath;
    }
	
    
    public void helper(TreeNode node, int sum, int target) {
    	sum += node.val;
    	if(node.left == null && node.right == null) {
    		if(sum == target) {
        		hasPath = true;
        	}
    		return;
    	}
    	if(node.left != null) {
    		helper(node.left, sum, target);
    	}
    	if(node.right != null) {
    		helper(node.right, sum, target);
    	}
    }
}
