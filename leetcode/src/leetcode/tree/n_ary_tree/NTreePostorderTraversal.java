package leetcode.tree.n_ary_tree;

import java.util.LinkedList;
import java.util.List;

import leetcode.entity.Node;

class NTreePostorderTraversal {

	private List<Integer> result = new LinkedList<Integer>();
	
    public List<Integer> postorder(Node root) {
       if(root == null) {
    	   return new LinkedList<>();
       }
       for (Node node : root.children) {
    	   postorder(node);
       }
       result.add(root.val);
       return result;
    }
	
}
