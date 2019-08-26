package leetcode.tree.trie;

public class MaxXORFinder {

	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	private TreeNode root;
	
	
    public int findMaximumXOR(int[] nums) {
        //创建树
    	root = createTree(nums);
    	//双指针搜索异或节点
    	return find(root, root);
    }


	private int find(TreeNode cur1, TreeNode cur2) {
		while(true) {
			if(cur1.left == null && cur1.right == null) {
				break;
			}
			
			//分治
			if(cur1.left != null && cur2.left != null && cur1.right != null && cur2.right != null) {
				return Math.max(find(cur1.left, cur2.right), find(cur2.left, cur1.right));
			}
			
			if(cur1.left != null && cur2.right != null) {
				cur1 = cur1.left;
				cur2 = cur2.right;
			}else if(cur1.right != null && cur2.left != null) {
				cur1 = cur1.right;
				cur2 = cur2.left;
			}else if(cur1.left != null && cur2.left != null) {
				cur1 = cur1.left;
				cur2 = cur2.left;
			}else if(cur1.right != null && cur2.right != null) {
				cur1 = cur1.right;
				cur2 = cur2.right;
			}
		}
		return cur1.val ^ cur2.val;
	}


	private TreeNode createTree(int[] nums) {
		TreeNode root = new TreeNode();
		for (int i : nums) {
			TreeNode cur = root;
			for (int j = 31; j >= 0; j--) {
				if(((i >> j) & 1) == 1) {
					if(cur.left == null) {
						cur.left = new TreeNode();
					}
					cur = cur.left;
				}else {
					if(cur.right == null) {
						cur.right = new TreeNode();
					}
					cur = cur.right;
				}
			}
			cur.val = i;
		}
		return root;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new MaxXORFinder().findMaximumXOR(new int[] {18,42,20,46}));
	}
}
