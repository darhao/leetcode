package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public List<TreeNode> generateTrees(int n) {
    	if(n == 0) {
    		return new ArrayList<TreeNode>();
    	}
		return gen(1, n);
    }

    
	private List<TreeNode> gen(int s, int e) {
		List<TreeNode> result = new ArrayList<>();
		
		if(s > e) {
			result.add(null);
			return result;
		}
		
		for (int i = s; i <= e; i++) {
			List<TreeNode> leftTreeNodes = gen(s, i-1);
			List<TreeNode> rightTreeNodes = gen(i+1, e);
			for (TreeNode r : rightTreeNodes) {
				for (TreeNode l : leftTreeNodes) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		
		return result;
	}
    
}
