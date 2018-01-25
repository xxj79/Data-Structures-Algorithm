package dp;

public class FindtheDerangementofAnArray {
    /*
    Transition equation:

    1) Swap current with any previous one when all previous digits are also deranged, 
    we have dp[i-1]*(i-1)
    2) Swap current with any digits that lie in its own position, we have dp[i-2]*(i-1)]

    Whih give us the equation dp[i] = (dp[i-1]+dp[i-2])*(i-1)
    */
    public int findDerangement(int n) {
        /*
        long[] dp = new long[n+1];
        final int mod =(int) Math.pow(10, 9)+7;
        if(n<=1) return 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3;i<=n;i++) dp[i] = ((dp[i-1]+dp[i-2])*(i-1))%mod;
        return (int)dp[n];
        */
        
        if(n<3) return n-1;
        long f = 0, s = 1;
        for(int i=2;i<n;i++){
            long temp = s;
            s = (f+s)*i%1000000007;
            f = temp;
        }
        return (int)s;
    }
}
