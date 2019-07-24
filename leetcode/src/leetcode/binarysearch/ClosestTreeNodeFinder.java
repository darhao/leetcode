package leetcode.binarysearch;

import leetcode.entity.TreeNode;

public class ClosestTreeNodeFinder {

    public int closestValue(TreeNode root, double target) {
        TreeNode gpar = null;
        TreeNode par = null;
        TreeNode curr = root;
        
        while(true) {
        	if(Math.abs(curr.val - target) < 0.5) {
        		return curr.val;
        	}else if(target > curr.val) {
        		if(curr.right == null) {
        			return getClosestValue(gpar, par, curr, target);
        		}else {
        			gpar = par;
        			par = curr;
        			curr = curr.right;
        		}
        	}else {
        		if(curr.left == null) {
        			return getClosestValue(gpar, par, curr, target);
        		}else {
        			gpar = par;
        			par = curr;
        			curr = curr.left;
        		}
        	}
        }
    }
    
    
    private int getClosestValue(TreeNode gpar, TreeNode par, TreeNode curr, double target) {
    	double gparD = gpar == null ? -1 : Math.abs(gpar.val - target);
    	double parD = par == null ? -1 : Math.abs(par.val - target);
    	double currD = Math.abs(curr.val - target);
    	if(gparD < parD && gparD != -1) {
    		if(gparD < currD) {
    			return gpar.val;
    		}else {
    			return curr.val;
    		}
    	}else {
    		if(parD < currD  && parD != -1) {
    			return par.val;
    		}else {
    			return curr.val;
    		}
    	}
    }
    
    
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(4);
    	TreeNode t1 = new TreeNode(2);
    	TreeNode t2 = new TreeNode(5);
    	TreeNode t3 = new TreeNode(1);
    	TreeNode t4 = new TreeNode(3);
    	root.left = t4;
    	t4.left = t3;
    	t4.right = t1;
    	root.right = t2;
		new ClosestTreeNodeFinder().closestValue(root, 0);
	}
	
}
