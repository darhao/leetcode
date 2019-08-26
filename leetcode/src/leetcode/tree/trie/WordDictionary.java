package leetcode.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

	private Trie trie;
	
	class Trie {

		class TrieNode{
			public Map<Character, TrieNode> children = new HashMap<>();
			public String val;
			public boolean isWord;
			public TrieNode(String val) {
				this.val = val;
			}
		}
		
		TrieNode root;
		
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
	    
	    public boolean search(String restKey, TrieNode cur) {
			if(restKey.length() == 0) {
				if(cur.isWord) {
					return true;
				}else {
					return false;
				}
			}
	    	char c = restKey.charAt(0);
	    	restKey = restKey.substring(1);
			if(c == '.') {
				for (TrieNode child : cur.children.values()) {
					if(search(restKey, child) == true) {
						return true;
					}
				}
				return false;
			}else {
				cur = cur.children.get(c);
				if(cur == null) {
					return false;
				}
				return search(restKey, cur);
			}
	    }
	    
	}
	
	/** Initialize your data structure here. */
	public WordDictionary() {
	    trie = new Trie();
	}
	
	/** Adds a word into the data structure. */
	public void addWord(String word) {
	    trie.insert(word);
	}
	
	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
	    return trie.search(word, trie.root);
	}
	
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		wordDictionary.search("pad");
		wordDictionary.search("bad");
		wordDictionary.search(".ad");
		wordDictionary.search("b..");
	}
}
