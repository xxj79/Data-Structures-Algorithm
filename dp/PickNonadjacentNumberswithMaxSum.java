package dp;

public class PickNonadjacentNumberswithMaxSum {
    public int pick(int[] a){
	int n = a.length;
	int[] dp = new int[n+1];
	dp[1] = a[0];
	for(int i = 2;i<=n;i++){
	    dp[i] = Math.max(dp[i-1], dp[i-2]+a[i-1]);
	}
	return dp[n];
    }
    
    public static void main(String[] args){
	PickNonadjacentNumberswithMaxSum obj = new PickNonadjacentNumberswithMaxSum();
	System.out.println((obj.pick(new int[]{4,1,1,9,1})));
    }
}
