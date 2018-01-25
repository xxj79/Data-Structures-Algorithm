package dp;


//Suppose we have already known how to convert word1[0..i - 2] to word2[0..j - 2], 
//which is dp[i - 1][j - 1]. Now let¡¯s consider word[i - 1] and word2[j - 1]. 
//If they are euqal, then no more operation is needed and dp[i][j] = dp[i - 1][j - 1]. 
//Well, what if they are not equal?
//
//If they are not equal, we need to consider three cases:
//
//Replace word1[i - 1] by word2[j - 1] 
//		(dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));

//Delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1] 
//		(dp[i][j] = dp[i - 1][j] + 1 (for deletion));

//Insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1] 
//		(dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
		
		
public class EditDistance {
	public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            
            int[][] cost = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++)
                cost[i][0] = i;
            for(int i = 1; i <= n; i++)
                cost[0][i] = i;
            
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        cost[i][j] = cost[i-1][j-1];
                    else {
                        cost[i][j] = Math.min(cost[i-1][j-1]+1, Math.min(cost[i][j-1]+1, cost[i-1][j]+1));
                    }
                }
            }
            return cost[m][n];
        }
	
	public int minDistance1D(String word1, String word2){
	    int m = word1.length();
            int n = word2.length();
            
            int[] cost = new int[n + 1];
            for(int i = 1; i <= n; i++)
                cost[i] = i;
            
            for(int i = 1; i <= m; i++) {
        	int pre = i;
                for(int j = 1; j <= n; j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                	cost[j] = pre;
                    }
                    else {
                	int temp = cost[j];
                        cost[j] = Math.min(pre+1, Math.min(cost[j-1]+1, cost[j]+1));
                        pre = temp;
                    }
                }
            }
            return cost[n];
	}
}
