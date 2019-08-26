package leetcode.tree.n_ary_tree;

import java.util.LinkedList;
import java.util.List;

import leetcode.entity.Node;

class NTreePreorderTraversal {

	private List<Integer> result = new LinkedList<Integer>();
	
    public List<Integer> preorder(Node root) {
       if(root == null) {
    	   return new LinkedList<>();
       }
       result.add(root.val);
       for (Node node : root.children) {
    	   preorder(node);
       }
       return result;
    }
	
}
