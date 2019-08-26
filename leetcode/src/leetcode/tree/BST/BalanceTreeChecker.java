package leetcode.tree.BST;

import java.util.HashMap;
import java.util.Map;

import leetcode.entity.TreeNode;

public class BalanceTreeChecker {

	private Map<TreeNode, Integer> treeHeight = new HashMap<>();
	
    public boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	int leftHeight = 0, rightHeight = 0;
    	boolean isLeftBalanced = true, isRightBalanced = true;
    	if(root.left != null) {
    		isLeftBalanced = isBalanced(root.left);
    		leftHeight = treeHeight.get(root.left);
    	}
    	if(root.right != null) {
    		isRightBalanced = isBalanced(root.right);
        	rightHeight = treeHeight.get(root.right);
        }
    	int myHeight = (leftHeight >= rightHeight ? leftHeight : rightHeight) + 1;
    	treeHeight.put(root, myHeight);
        return Math.abs(leftHeight - rightHeight) <= 1 && isLeftBalanced && isRightBalanced;
    }
	
}
