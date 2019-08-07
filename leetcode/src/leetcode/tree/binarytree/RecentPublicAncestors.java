package leetcode.tree.binarytree;

import java.util.Stack;

import leetcode.entity.TreeNode;

public class RecentPublicAncestors {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null) {
    		return null;
    	}
    	Stack<TreeNode> stack1 = new Stack<>();
    	Stack<TreeNode> stack2 = new Stack<>();
    	helper(stack1, root, p);
    	helper(stack2, root, q);
    	if(stack1.size() >= stack2.size()) {
    		int a = stack1.size() - stack2.size();
    		for (int i = 0; i < a; i++) {
				stack1.pop();
			}
    	}else {
    		int a = stack2.size() - stack1.size();
    		for (int i = 0; i < a; i++) {
				stack2.pop();
			}
    	}
    	while(stack1.peek() != stack2.peek()) {
    		stack1.pop();
    		stack2.pop();
    	}
    	return stack1.peek();
    }
    
    
    private void helper(Stack<TreeNode> stack, TreeNode cur, TreeNode target) {
    	if(cur == null) {
    		return;
    	}
    	stack.push(cur);
    	helper(stack, cur.left, target);
    	helper(stack, cur.right, target);
    	if(stack.peek() != target) {
    		stack.pop();
    	}
    	return;
    }
	
}
