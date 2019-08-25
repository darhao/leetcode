package leetcode.tree.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordReplacer {

	private Trie trie;
	
    public String replaceWords(List<String> dict, String sentence) {
        trie = new Trie();
    	for (String string : dict) {
			trie.insert(string);
		}
    	String[] words = sentence.split("\\s");
    	StringBuilder builder = new StringBuilder();
    	for (String string : words) {
			string = trie.getWordRoot(string);
			builder.append(string + " ");
		}
    	return builder.toString().trim();
    }
    
    class Trie{
    	class TrieNode{
    		public Map<Character, TrieNode> children = new HashMap<>();
    		public String val;
    		public boolean isWordRoot;
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
        	cur.isWordRoot = true;
        }
        
        public String getWordRoot(String word) {
            TrieNode cur = root;
        	for (int i = 0; i < word.length(); i++) {
    			char c = word.charAt(i);
    			TrieNode child = cur.children.get(c);
    			if(child == null) {
    				return word;
    			}
    			cur = child;
    			if(cur.isWordRoot) {
    				return cur.val;
    			}
    		}
        	return word;
        }
    }
	
}
