package leetcode.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	class TrieNode{
		public Map<Character, TrieNode> children = new HashMap<>();
		public String val;
		public boolean isWord;
		public TrieNode(String val) {
			this.val = val;
		}
	}
	
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode("");
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
    	for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode child = cur.children.get(c);
			if(child == null) {
				child = new TrieNode(cur.val + String.valueOf(c));
				cur.children.put(c, child);
			}
			cur = child;
		}
    	cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode cur = root;
    	for (int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
			TrieNode child = cur.children.get(c);
			if(child == null) {
				return false;
			}
			cur = child;
		}
    	return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
    	for (int i = 0; i < prefix.length(); i++) {
    		char c = prefix.charAt(i);
			TrieNode child = cur.children.get(c);
			if(child == null) {
				return false;
			}
			cur = child;
		}
    	return true;
    }
	
}
