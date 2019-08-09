package leetcode.tree.BST;

public class KthLargest {

	MyTreeNode root;
	int kk;
	
	
	class MyTreeNode {
		int val;
		int childrenNum;
		MyTreeNode left;
		MyTreeNode right;
		public MyTreeNode(int val) {
			this.val = val;
		}
	}
	
	
    public KthLargest(int k, int[] nums) {
    	//初始化树，如果树为空就不初始化
        if(nums.length != 0) {
        	root = new MyTreeNode(nums[0]);
        	for (int i = 1; i < nums.length; i++) {
				insert(root, nums[i]);
			}
    	}
        //持有K
        kk = k;
    }
    
    
    public int add(int val) {
    	//特殊情况：若初始时为空数组，则k必为1，所以直接返回val
        if(root == null) {
        	root = new MyTreeNode(val);
        	return val;
        }
    	
        //一般情况：
        //先把值插入树中
        insert(root, val);
        //寻找第k大节点的值
        MyTreeNode cur = root;
        int k = kk;
        while(true) {
        	//1)计算a，a = (右节点的孩子数+1)[前提是有右节点] + 1
        	int a = (cur.right != null ? cur.right.childrenNum + 1 : 0) + 1;
        	//2)比较a与k，如果a==k就返回cur的值
        	if(a == k) {
        		break;
        	}else if(a > k) {//如果a>k则cur右移
        		cur = cur.right;
        	}else {//如果a<k则cur左移，并且k=k-a
        		cur = cur.left;
        		k-=a;
        	}
        }
        return cur.val;
    }
	
    
    private void insert(MyTreeNode node, int val) {
    	node.childrenNum++;
    	if(node.val > val) {
    		if(node.left != null) {
    			insert(node.left, val);
    		}else {
    			node.left = new MyTreeNode(val);
    		}
    	}else {
    		if(node.right != null) {
    			insert(node.right, val);
    		}else {
    			node.right = new MyTreeNode(val);
    		}
    	}
    }
}
