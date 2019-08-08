package leetcode.tree.BST;

import java.util.Stack;

import leetcode.entity.TreeNode;

public class BSTIterator {

	private Stack<TreeNode> stack;
	
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
        int result = node.val;
        node = node.right;
        while(node != null) {
        	stack.push(node);
        	node = node.left;
        }
        return result;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
