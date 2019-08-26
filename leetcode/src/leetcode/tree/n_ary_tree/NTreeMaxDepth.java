package leetcode.tree.n_ary_tree;

import leetcode.entity.Node;

public class NTreeMaxDepth {

    public int maxDepth(Node root) {
    	if(root == null) {
    		return 0;
    	}
        int maxDepth = 0;
    	for (Node node : root.children) {
    		int depth = maxDepth(node);
			if(depth > maxDepth) {
				maxDepth = depth;
			}
		}
    	return ++maxDepth;
    }
	
}
