package leetcode.tree.n_ary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.entity.Node;

public class NTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> result = new LinkedList<>();
    	Queue<Node> queue = new LinkedList<>();
    	if(root != null) {
    		queue.offer(root);
    	}
    	while(!queue.isEmpty()) {
    		List<Integer> level = new LinkedList<>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			Node node = queue.poll();
    			level.add(node.val);
    			for (Node n : node.children) {
					queue.offer(n);
				}
			}
    		result.add(level);
    	}
		return result;
    }
	
}
