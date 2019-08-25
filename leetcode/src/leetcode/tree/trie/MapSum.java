package leetcode.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

	class TrieNode{
		public Map<Character, TrieNode> children = new HashMap<>();
		public String prefix;
		public int val;
		public TrieNode(String prefix) {
			this.prefix = prefix;
		}
	}
	
	private TrieNode root;
	private Map<String, Integer> map;
	
    /** Initialize your data structure here. */
    public MapSum() {
    	root = new TrieNode("");
    	map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
    	Integer oldVal = map.getOrDefault(key, 0);
    	map.put(key, val);
		val -= oldVal;
    	TrieNode cur = root;
    	for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			TrieNode child = cur.children.get(c);
			if(child == null) {
				child = new TrieNode(cur.prefix + String.valueOf(c));
				cur.children.put(c, child);
			}
			cur = child;
			child.val += val;
		}
    }
    
    public int sum(String prefix) {
    	TrieNode cur = root;
    	for (int i = 0; i < prefix.length(); i++) {
    		char c = prefix.charAt(i);
			TrieNode child = cur.children.get(c);
			if(child == null) {
				return 0;
			}
			cur = child;
		}
    	return cur.val;
    }
	
}
