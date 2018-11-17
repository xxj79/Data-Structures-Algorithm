package dfs;

import java.util.*;

//Just a normal backtracking problem!!
//with an extra check if it's palidrome method.

public class PalidromePartition {
    public List<List<String>> partition(String s){
	List<List<String>> ret = new ArrayList<>();
	dfs(s, 0, new ArrayList<>(), ret);
	return ret;
    }
    
    private void dfs(String s, int pos, List<String> list, List<List<String>> ret){
	if(pos == s.length()) ret.add(new ArrayList<String>(list));
	else{
	    for(int i=pos;i<s.length();i++){
		if(isPal(s, pos, i)){
		    list.add(s.substring(pos, i+1));
		    dfs(s, i+1,list,ret);
		    list.remove(list.size()-1);
		}
	    }
	}
    }
    
    private boolean isPal(String s, int low, int high){
	while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
	return true;
    }
    
    
    //And for for checking if is palindrome part, we can use DP, to make the total time
    //complexity from O(n*(2^n)) to o(n^2 + 2^n)
    public List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
