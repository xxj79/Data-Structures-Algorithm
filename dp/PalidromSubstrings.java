package dp;

public class PalidromSubstrings {
    /*
     * dp appraoch
     * 
     * dp[i][j] = true --> iif char(i) == char(j) && (j-i<3 || dp[i+1][j-1] == true)
     */
    
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }
    
    //And of course we can use extend from center approach, which is more straightforward
}
