package leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import leetcode.entity.TreeNode;

public class PostOrderTraversal {

	//左右中
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<>();
    	helper(root, result);
    	return result;
    }
    
    
    public void helper(TreeNode node, List<Integer> result) {
    	if(node == null) {
    		return;
    	}
    	helper(node.left, result);
    	helper(node.right, result);
    	result.add(node.val);
    }
	
}
