package leetcode.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import leetcode.entity.TreeNode;

public class BinaryTreeSerializer {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
        	return "[]";
        }
    	List<List<TreeNode>> levels = new ArrayList<>();
    	List<TreeNode> rootLevel = new ArrayList<>();
    	rootLevel.add(root);
        levels.add(rootLevel);
        boolean isEnd = false;
        while(!isEnd) {
        	List<TreeNode> fatherLevel = levels.get(levels.size() - 1);
        	List<TreeNode> newLevel = new ArrayList<>();
        	isEnd = true;
        	for (int i = 0; i < fatherLevel.size(); i++) {
        		TreeNode fatherNode = fatherLevel.get(i);
        		if(fatherNode != null) {
        			newLevel.add(fatherNode.left == null ? null : fatherNode.left);
        			newLevel.add(fatherNode.right == null ? null : fatherNode.right);
        			if(fatherNode.left != null  || fatherNode.right != null) {
            			isEnd = false;
            		}
        		}
        	}
        	if(!isEnd) {
        		levels.add(newLevel);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<TreeNode> treeNodes : levels) {
			for (TreeNode treeNode : treeNodes) {
				sb.append(treeNode != null ? treeNode.val + "," : "null,");
			}
		}
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.equals("[]")) {
    		return null;
    	}
        String[] nodesString = data.substring(1, data.length() -  1).split(",");
        TreeNode[] nodes = new TreeNode[nodesString.length];
        for (int i = 0; i < nodes.length; i++) {
			nodes[i] = nodesString[i].equals("null") ? null : new TreeNode(Integer.parseInt(nodesString[i]));
        }
        
        if(nodes.length == 0) {
        	return null;
        }
        
        TreeNode root = nodes[0];
        int index = 0;
        int notNullNodeIndex = 0;
        while(true) {
        	if(notNullNodeIndex * 2 + 2 >= nodes.length) {
        		break;
        	}
        	if(nodes[index] != null) {
        		nodes[index].left = nodes[notNullNodeIndex * 2 + 1];
            	nodes[index].right = nodes[notNullNodeIndex * 2 + 2];
            	notNullNodeIndex++;
        	}
        	index++;
        }
        return root;
    }
    
    
    public static void main(String[] args) {
		new BinaryTreeSerializer().serialize(new BinaryTreeSerializer().deserialize("[1,3,null,null,4]"));
	}
	
}
