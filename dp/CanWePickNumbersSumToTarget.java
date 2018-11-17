package dp;

public class CanWePickNumbersSumToTarget {
    public boolean pick(int[] a, int t){
	boolean[][] dp = new boolean[a.length+1][t+1];
	dp[0][0] = true;
	for(int i = 1;i<=a.length;i++){
	    for(int j = 1; j<=t;j++){
		dp[i][j] = j>=a[i-1] ? (dp[i-1][j] || dp[i-1][j - a[i-1]]) : dp[i-1][j];
	    }
	}
	return dp[a.length][t];
    }
    
    public static void main(String[] args){
	CanWePickNumbersSumToTarget obj = new CanWePickNumbersSumToTarget();
	int[] a = {3,34,4,12,5,2};
	System.out.println(obj.pick(a, 9));
    }
}
