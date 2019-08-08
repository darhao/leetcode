package leetcode.tree.binarytree;

import leetcode.entity.TreeNode;

public class InOrderAndPostOrderTreeBuilder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	//基本情况判断
    	if(inorder.length == 0 && postorder.length == 0) {
    		return null;
    	}
    	
        //从后序遍历最后一个元素获取根节点
    	int root = postorder[postorder.length - 1];
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
        int[] newLeftPostOrder = new int[leftLength];
        for (int i = 0; i < leftLength; i++) {
			newLeftInorder[i] = inorder[i];
			newLeftPostOrder[i] = postorder[i];
		}
        //生成左子树，并让父节点连接
        rootNode.left = buildTree(newLeftInorder, newLeftPostOrder);
        
        //右递归
        int rightLength = inorder.length - rootIndexInInorder - 1;
        int[] newRightInorder = new int[rightLength];
        int[] newRightPostOrder = new int[rightLength];
        for (int i = 0; i < rightLength; i++) {
        	newRightInorder[i] = inorder[rootIndexInInorder + 1 + i];
        	newRightPostOrder[i] = postorder[leftLength + i];
		}
        //生成柚子树，并让父节点连接
        rootNode.right = buildTree(newRightInorder, newRightPostOrder);
        
        //返回根节点
        return rootNode;
    }
}
