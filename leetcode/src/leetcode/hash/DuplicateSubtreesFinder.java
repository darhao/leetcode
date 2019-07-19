package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtreesFinder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	class MyTreeNode {

		Integer hash;
		
		TreeNode node;
		
		MyTreeNode left;
		MyTreeNode right;
		
		MyTreeNode(TreeNode node) {
			this.node = node;
			if(node.left != null) {
				left = new MyTreeNode(node.left);
			}
			if(node.right != null) {
				right = new MyTreeNode(node.right);
			}
		}
		
		@Override
		public int hashCode() {
			if(hash != null) {
				return hash;
			}
			String s = node.val + "";
			if(left != null) {
				s += "L" + left.hashCode();
			}
			if(right != null) {
				s += "R" + right.hashCode();
			}
			hash = s.hashCode();
			return hash;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
		
	}
	
	private Map<MyTreeNode, Integer> repeatCountMap = new HashMap<>();
	
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) {
        	return new ArrayList<>();
        }
        repeatCountMap = new HashMap<>();
        dfs(new MyTreeNode(root));
        List<TreeNode> result = new ArrayList<>();
        for (MyTreeNode node : repeatCountMap.keySet()) {
			if(repeatCountMap.get(node) > 1) {
				result.add(node.node);
			}
		}
        return result;
    }
    
    
    private void dfs(MyTreeNode node) {
    	if(node == null) {
    		return;
    	}
		repeatCountMap.put(node, repeatCountMap.get(node) == null ? 1 : repeatCountMap.get(node) + 1);
		dfs(node.left);
		dfs(node.right);
    }
	
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		root.left = node;
		root.right = node2;
		new DuplicateSubtreesFinder().findDuplicateSubtrees(root);
	}
}
