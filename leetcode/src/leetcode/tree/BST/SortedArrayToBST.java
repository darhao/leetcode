package leetcode.tree.BST;

import leetcode.entity.TreeNode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
    	return genNode(nums, 0, nums.length - 1);
    }
    
    
    private TreeNode genNode(int[] nums, int left, int right) {
    	if(left > right) {
    		return null;
    	}
    	int mid = left + (right - left) / 2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = genNode(nums, left, mid - 1);
    	node.right = genNode(nums, mid + 1, right);
    	return node;
    }
	
}
