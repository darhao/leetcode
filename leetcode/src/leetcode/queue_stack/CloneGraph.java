package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	private Map<Node, Node> oldNewMap = new HashMap<>();
	
    public Node cloneGraph(Node node) {
    	//判断是否已经访问
    	if(oldNewMap.containsKey(node)) {
    		return oldNewMap.get(node);
    	}
    	Node copy = new Node();
    	//标记访问并绑定
    	oldNewMap.put(node, copy);
    	//赋值
    	copy.val = node.val;
    	copy.neighbors = new ArrayList<>();
    	for (Node neighbor : node.neighbors) {
    		copy.neighbors.add(cloneGraph(neighbor));
		}
    	return copy;
    }
	
}
