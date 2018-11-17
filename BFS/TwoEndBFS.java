package BFS;

import java.util.*;


/*
 * Leetcode 127. Word Ladder
 *
 * A "finding shortest distance" problem, whcih is a typical use-case of BFS
 * 
 */

//Classic BFS (two-end BFS problem)
//Two-end bfs: Keep two queues/sets starting from both ends, always explore from 
//the one with smaller size (by exchange their reference in the bfs body code), which 
//would avoid from searching too wide and speed up the performance a lot!!!
//In BFS body, queue and set both work


//Also notice how this approach compare two words to find the neighbor words

public class TwoEndBFS {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()){
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        return twoEndBFS(beginWord, endWord, wordSet);
    }
    private int twoEndBFS(String beginWord, String endWord, Set<String> wordList){
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() || !wordList.contains(endWord)){
            return 0;
        }
        
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        int len = 1;
        q1.add(beginWord);
        q2.add(endWord);

        while(!q1.isEmpty() && !q2.isEmpty()){
        	
        	//Adjust the search set, always search from the smaller one
            if(q1.size() > q2.size()){
                Deque<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            
            int length = q1.size();
            for(int k=0;k<length;k++){
                String word = q1.poll();
                char[] chars = word.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char old = chars[i];
                        chars[i] = c;
                        String target = new String(chars);
                        if(wordList.contains(target) && q2.contains(target)){
                            return len + 1;
                        }
                        if(!visited.contains(target) && wordList.contains(target)){
                            q1.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
