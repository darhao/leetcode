package leetcode.recursion;

public class MaxDepth {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return getDepth(0, root);
	}
	
	private int getDepth(int currentDepth, TreeNode node) {
		if(node == null) {
			return currentDepth;
		}
		int leftDepth = getDepth(currentDepth+1, node.left);
		int rightDepth = getDepth(currentDepth+1, node.right);
		return leftDepth >= rightDepth ? leftDepth : rightDepth;
	}
}
