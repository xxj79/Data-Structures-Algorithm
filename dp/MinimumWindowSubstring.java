package dp;

//Given strings S and T, find the minimum (contiguous) substring W of S, 
//so that T is a subsequence of W.
//
//If there is no such window in S that covers all characters in T, return 
//the empty string "". If there are multiple such minimum-length windows, 
//return the one with the left-most starting index.


//O(S*T), dp[i][j] means the substring: 
//S.substring(j-dp[i][j],j) that match T.substring(0, i) 
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = n + 1; //important
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        
        String res = "";
        int min = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] < min) {
                min = dp[m][j];
                res = S.substring(j - min, j);
            }
        }
        return res;
    }
}
