package dp;

import java.util.*;

public class WordBreakII {
	/*
	 * Memoization DP, map string to the corresponding result(List<String>)
	 */
	public List<String> wordBreak(String s, List<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
	/*
	 * Eearly termination/cut backtracking, use an array to indicate whether the substring
	 * starting from this index is breakable or not.
	 */
	List<String> rst = new ArrayList<>();
    boolean[] f;
    String s;
    List<String> wordDict;
    int l;

    public List<String> wordBreak1(String s, List<String> wordDict) {
        // Write your code here
        if (s == null || s.length() == 0 || wordDict == null) {
            return rst;
        }
        int len = s.length();
        this.f = new boolean[len + 1];
        this.s = s;
        this.wordDict = wordDict;
        this.l = s.length();
        int maxLength = 0;
        for (String st : wordDict) {
            int length = st.length();
            maxLength = Math.max(maxLength, length);
        }
        f[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j - i < maxLength && j < len; j++) {
                if (f[j + 1] && wordDict.contains(s.substring(i, j + 1))) {
                    f[i] = true;
                    break;
                }
            }
        }
        dfs(0, "");
        return rst;
    }
    void dfs(int pos, String str) {
        if (pos == l) {
            str = str.substring(0, str.length() - 1);
            rst.add(str);
            return;
        }
        if (!f[pos]) {
            return;
        }
        for (int i = pos; i < l; i++) {
            String curtS = s.substring(pos, i + 1);
            if (wordDict.contains(curtS)) {
                dfs(i + 1, str + curtS + " ");
            }
        }
    }
}
