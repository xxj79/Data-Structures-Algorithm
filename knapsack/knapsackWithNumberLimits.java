package knapsack;
/*
 * 有一个重量限制m，还有一个个数限制n，求最高价值
 */
public class knapsackWithNumberLimits {
    public int solution(int[] w, int[] v, int m, int n){
	int len = v.length;
	int[][][] dp = new int[m+1][len+1][n+1];
	for(int i = 1; i<=m; i++){
	    for(int j = 1; j<=len; j++){
		for(int k = 1; k<=n; k++){
		    if(k<=j){
			dp[i][j][k] = Math.max(dp[i][j-1][k], dp[i-w[j-1]][j-1][k] + v[j-1]);
		    } else{
			dp[i][j][k] = Math.max(dp[i][j-1][k], dp[i-w[j-1]][j-1][k-1] + v[j-1]);
		    }
		}
	    }
	}
	return dp[m][len][n];
    }
    
    
    public int solution2D(int[] w, int[] v, int m, int n){
	int len = v.length;
	int[][] dp = new int[m+1][len+1];
	for(int i = 1; i<=m; i++){
	    for(int j = 1; j<=len; j++){
		int[][] temp = dp.clone();
		for(int k = 1; k<=n; k++){
		    if(k<=j){
			dp[i][j] = Math.max(dp[i][j-1], dp[i-w[j-1]][j-1] + v[j-1]);
		    } else{
			dp[i][j] = Math.max(dp[i][j-1], temp[i-w[j-1]][j-1] + v[j-1]);
		    }
		    temp = dp.clone();
		}
	    }
	}
	return dp[m][len];
    }
}
