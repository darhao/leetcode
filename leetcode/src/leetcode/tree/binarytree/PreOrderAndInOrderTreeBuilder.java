package leetcode.tree.binarytree;

import leetcode.entity.TreeNode;

public class PreOrderAndInOrderTreeBuilder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	//基本情况判断
    	if(inorder.length == 0 && preorder.length == 0) {
    		return null;
    	}
    	
        //从前序遍历第一个元素获取根节点
    	int root = preorder[0];
    	//生成根节点
    	TreeNode rootNode = new TreeNode(root);
    	
        //找到根节点在中序遍历中的位置
        int rootIndexInInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
			if(root == inorder[i]) {
				rootIndexInInorder = i;
			}
		}
        
        //左递归
        int leftLength = rootIndexInInorder;
        int[] newLeftInorder = new int[leftLength];
        int[] newLeftPreOrder = new int[leftLength];
        for (int i = 0; i < leftLength; i++) {
			newLeftInorder[i] = inorder[i];
			newLeftPreOrder[i] = preorder[1 + i];
		}
        //生成左子树，并让父节点连接
        rootNode.left = buildTree(newLeftPreOrder, newLeftInorder);
        
        //右递归
        int rightLength = inorder.length - rootIndexInInorder - 1;
        int[] newRightInorder = new int[rightLength];
        int[] newRightPreOrder = new int[rightLength];
        for (int i = 0; i < rightLength; i++) {
        	newRightInorder[i] = inorder[rootIndexInInorder + 1 + i];
        	newRightPreOrder[i] = preorder[1 + leftLength + i];
		}
        //生成柚子树，并让父节点连接
        rootNode.right = buildTree(newRightPreOrder, newRightInorder);
        
        //返回根节点
        return rootNode;
    }
	
}
