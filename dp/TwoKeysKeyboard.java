package dp;

/*
 * DP with greedy idea applied.
 */
public class TwoKeysKeyboard {

    public int minSteps(int n){
	int[] dp = new int[n+1];
	for(int i=2;i<=n;i++){
	    dp[i] = i;
	    for(int j=i/2;j>1;j--){
		if(i%j==0){
		    dp[i]=dp[j]+(i/j);
		    break;
		}
	    }
	}
	return dp[n];
    }
    //We can also use D&Q, which is faster
    public int minSteps1(int n) {
        if (n == 1) return 0;
        for (int i = 2; i < n; i++)
            if (n % i == 0) return i + minSteps(n / i);
        return n;
    }
}
