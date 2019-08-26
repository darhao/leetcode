package leetcode.tree.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairsFinder {

	private Trie trie;
	
	class Trie {

		class TrieNode{
			public Map<Character, TrieNode> children = new HashMap<>();
			public String val;
			public Integer wordIndex;
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
	    public void insert(String word, int index) {
	        TrieNode cur = root;
	    	for (int i = word.length() - 1; i >= 0; i--) {
				char c = word.charAt(i);
				TrieNode child = cur.children.get(c);
				if(child == null) {
					child = new TrieNode(String.valueOf(c) + cur.val);
					cur.children.put(c, child);
				}
				cur = child;
			}
	    	cur.wordIndex = index;
	    }
	    
	    public List<Integer> getPairIndexs(String word) {
	    	List<Integer> indexs = new LinkedList<>();
	    	//如果包含空串，就直接判断单词是否回文
	    	TrieNode cur = root;
	    	if(cur.wordIndex != null) {
	    		if(isPairs(word)) {
					indexs.add(cur.wordIndex);
				}
	    	}
	    	for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode child = cur.children.get(c);
				if(child == null) {//单词未遍历完，但树遍历完了，退出
					break;
				}else {
					if(child.wordIndex != null) {//单词未遍历完，树遍也未完，先判断是不是单词，然后是再判断是不是能凑成回文
						if(isPairs(word + child.val)) {
							indexs.add(child.wordIndex);
						}
					}
					cur = child;
				}
			}
	    	//单词遍历完了，树未遍历完，进行深度优先搜索
	    	for (TrieNode child : cur.children.values()) {
	    		dfs(word, child, indexs);
			}
	    	return indexs;
	    }
	    
	    
	    private void dfs(String word, TrieNode cur, List<Integer> indexs) {
	    	if(isPairs(word + cur.val)) {
	    		if(cur.wordIndex != null) {
					indexs.add(cur.wordIndex);
				}
	    	}
	    	for (TrieNode node : cur.children.values()) {
				dfs(word, node, indexs);
			}
	    }
	    
	    
	    private boolean isPairs(String word) {
	    	for (int i = 0; i < word.length() / 2; i++) {
				if(word.charAt(i) != word.charAt(word.length() - 1 - i)) {
					return false;
				}
			}
	    	return true;
	    }
	    
	}
	
    public List<List<Integer>> palindromePairs(String[] words) {
    	//构造单词后缀树
    	trie = new Trie();
    	for (int i = 0; i < words.length; i++) {
			trie.insert(words[i], i);
		}
    	
    	//搜索并填充结果
    	List<List<Integer>> results = new LinkedList<>();
    	for (int i = 0; i < words.length; i++) {
    		List<Integer> pairIndexs = trie.getPairIndexs(words[i]);
			for (Integer pairIndex : pairIndexs) {
				if(i != pairIndex) {//相同索引去掉
					List<Integer> result = new LinkedList<>();
					result.add(i);
					result.add(pairIndex);
					results.add(result);
				}
			}
		}
    	return results;
    }
    
    
    public static void main(String[] args) {
		new PalindromePairsFinder().palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"});
	}
	
}
