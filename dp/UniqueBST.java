package dp;

/*
DP, consider using each node as root node, and each subtree
can be represented with the substructure

We got 
	G(n) = F(1, n) + F(2, n) + ... + F(n, n)
and
	F(i, n) = G(i-1) * G(n-i)	1 <= i <= n

which lead to:

G(n) = G(0) * G(n-1) + G(1) * G(n-2) + бн + G(n-1) * G(0)  

So to know G(n), need to know G(0) to G(n-1)
which can use DP!!

Notice the base case should be dp[0] = dp[1] = 1
*/
public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            for(int j=1;j<=i;j++)
                dp[i] += dp[j-1]*dp[i-j];
        return dp[n];
    }
}
