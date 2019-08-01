package leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import leetcode.entity.TreeNode;

public class PreOrderTraversal {

	//中左右
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<>();
    	helper(root, result);
    	return result;
    }
    
    
    public void helper(TreeNode node, List<Integer> result) {
    	if(node == null) {
    		return;
    	}
    	result.add(node.val);
    	helper(node.left, result);
    	helper(node.right, result);
    }
	
}
