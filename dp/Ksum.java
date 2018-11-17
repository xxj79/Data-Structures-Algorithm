package dp;

/*
 * Given n distinct positive integers, integer k (k<=n) and a number target.
 * 
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 */
public class Ksum {
    public int kSum(int[] A, int k, int target){
	if(A == null || A.length == 0){
	    return 0;
	}
	
	int n = A.length;
	int[][][] dp = new int[target+1][n+1][k+1];
	
	for(int j = 0;j<=n;j++)
	    dp[0][j][0] = 1;
	
	for(int i = 1;i<=target;i++){
	    for(int j = 1;j<=n;j++){
		for(int l = 1;l<=j && l<=k;l++){
		    dp[i][j][l] = dp[i][j-1][l];
		    if(i - A[j-1] >= 0)
			dp[i][j][l] += dp[i-A[j-1]][j-1][l-1];
		}
	    }
	}
	return dp[target][n][k];
    }
}
