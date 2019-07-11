package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        iterate(result, root);
        return result;
    }
    
    
    public void iterate(List<Integer> result, TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	iterate(result, node.left);
    	result.add(node.val);
    	iterate(result, node.right);
    }
	
}
