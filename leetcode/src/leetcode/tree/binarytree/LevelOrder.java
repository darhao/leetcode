package leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.entity.TreeNode;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	if(root != null) {
    		queue.offer(root);
    	}
    	while(!queue.isEmpty()) {
    		List<Integer> level = new LinkedList<>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			level.add(node.val);
    			if(node.left != null) {
    				queue.offer(node.left);
				}
    			if(node.right != null) { 
    				queue.offer(node.right);
    			}
			}
    		result.add(level);
    	}
		return result;
    }
	
}
