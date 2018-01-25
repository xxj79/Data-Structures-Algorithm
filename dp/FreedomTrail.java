package dp;

import java.util.*;
//dp[i][j]: the min steps required when 
// 1) the jth element of ring is at the 12:00
// 2) the remaining key is key.substring(i)
// this is for memorioation purpose
public class FreedomTrail {

    //DP, hard to figure out.
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        
        return dp[0][0] + m;
    }
    
    //DFS + Memoization, easier to understand
    
    // map: for every unique char in ring, find all its occurances.
    Map<Character, Set<Integer>>map;
    
    // memo[i][j]: the min steps required when 
    // 1) the jth element of ring is at the 12:00
    // 2) the remaining key is key.substring(i)
    // this is for memorioation purpose
    int[][] memo;
    public int findRotateStep1(String ring, String key) {
        int n = ring.length(), m = key.length();

        map = new HashMap<>();
        for (int i=0;i<n;i++){
            char c=ring.charAt(i);
            map.putIfAbsent(c, new HashSet<>());
            map.get(c).add(i);
        }
        
        // initialize the memo: -1 represents not calculated yet.
        memo = new int[m][n];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                memo[i][j]=-1;
        
        // "+m" is the m spelling steps 
        return helper(ring, key, 0, 0)+m;
    }
    
    private int helper(String ring, String key, int x, int y){
        if (x==key.length()) return 0;
        if (memo[x][y]>=0) return memo[x][y];
        
        int min=Integer.MAX_VALUE;
        for (int k:map.get(key.charAt(x))){
            int diff=Math.abs(k-y);
            int step=Math.min(diff, ring.length()-diff);
            min=Math.min(min, step+helper(ring, key, x+1, k));
        }
        memo[x][y]=min;
        return min;
    }
}
