package leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.entity.TreeNode;

public class SymmetricTreeChecker {
	
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		Integer[] level = new Integer[size*2];
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if(node.left != null) {
    				queue.offer(node.left);
    				level[i*2] = node.left.val;
				}else {
					level[i*2] = null;
				}
    			if(node.right != null) { 
    				queue.offer(node.right);
    				level[i*2+1] = node.right.val;
    			}else {
    				level[i*2+1] = null;
    			}
			}
    		for (int i = 0; i < level.length / 2; i++) {
    			Integer a = level[i];
    			Integer b = level[level.length - 1 - i];
    			if(a == null && b == null) {
    				continue;
    			}
    			if((a == null && b != null) || (a != null && b == null)) {
    				return false;
    			}
    			if(a.intValue() != b.intValue()) {
    				return false;
    			}
    		}
    	}
		return true;
    }
	
}
