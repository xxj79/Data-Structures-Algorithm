package trie;

import java.util.*;

public class WordBreak {
	public class TrieNode{
		boolean isWord;
		TrieNode[] child;
		
		public TrieNode(){
			isWord = false;
			child = new TrieNode[26];
		}
	}
	
	public void addWord(TrieNode t, String w){
		for(int i=0;i<w.length();i++){
			int j = w.charAt(i) - 'a';
			if(t.child[j] == null) t.child[j] = new TrieNode();
			t = t.child[j];
		}
		t.isWord = true;
	}
	
	public boolean wordBreak(String s, Set<String> wordDict){
		TrieNode t = new TrieNode(), cur;
		for(String i : wordDict) addWord(t, i);
		char[] str = s.toCharArray();
		boolean[] f = new boolean[str.length+1];
		f[str.length] = true;
		//Note for trie in this problem, we needs to scan backwards to take advantege of previous
		// cache result.
		for(int i=str.length-1;i>=0;i--){
			cur = t;
			for(int j=i;cur!=null && j<str.length;j++){
				cur = cur.child[str[j]-'a'];
				if(cur!=null && cur.isWord && f[j+1]){
					f[i] = true;
					break;
				}
			}
		}
		return f[0];
	}
}
