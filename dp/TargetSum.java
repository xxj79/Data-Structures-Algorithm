package dp;

//Classic knapsack

//You are given a list of non-negative integers, a1, a2, ..., an, 
//and a target, S. Now you have 2 symbols + and -. For each integer, 
//you should choose one from + and - as its new symbol.
//
//Find out how many ways to assign symbols to make sum of integers 
//equal to target S.

public class TargetSum {
    //Smart way:
    //        sum(P) - sum(N) = target
    //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //             2 * sum(P) = target + sum(nums)
    //So the original problem has been converted to a subset sum problem as follows:
    //Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 
    
    //Knapsack dp:
    //dp[i][j]: how many ways we can achieve sum j using first i numbers?
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null) { return 0; }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S < -sum || S > sum) { return 0;}
        int n = nums.length;
        int[][] f = new int[n + 1][2 * sum + 1];
        f[0][0 + sum] = 1;//It seems like make no sense, but it is the base value;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) { 
                if (j - nums[i - 1] >= 0) {
                    f[i][j] += f[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum) {
                    f[i][j] += f[i - 1][j + nums[i - 1]];
                }
            }
        }
        
        return f[n][sum + S];
    }
    
    //Optimized to 1D
    public int findTargetSumWays2(int[] nums, int S) {
        
        int sum = 0, n = nums.length;
        
        for(int num : nums) sum += num;
        
        if(sum<S || -sum>S) return 0;
        
        int[] dp = new int[2*sum+1];
        dp[sum] = 1;
        for(int i = 1;i<=n;i++){
            int[] temp = new int[2*sum+1];
            for(int j = 0;j<=2*sum;j++){
                if(j-nums[i-1]>=0)
                    temp[j] += dp[j-nums[i-1]];
                if(j+nums[i-1]<=2*sum)
                    temp[j] += dp[j+nums[i-1]];
            }
            dp = temp;
        }
        
        return dp[sum + S];
    }
    
    //Top down memo
    int sum = 0;
    public int findTargetSumWays3(int[] nums, int S) {
        int n = nums.length;
        for(int num : nums) sum+=num;
        if(sum<S || S<(-1)*sum) return 0;
        
        Integer[][] memo = new Integer[n][2*sum+1];
        return dfs(memo, nums, S, 0);
    }
    
    int dfs(Integer[][] memo, int[] nums, int S, int n){
        if(n == nums.length) return S == 0 ? 1 : 0;
        if(S+sum>2*sum) return 0;
        if(memo[n][S+sum] != null) return memo[n][S+sum];
        
        int ret = dfs(memo, nums, S-nums[n], n+1) + dfs(memo, nums, S+nums[n], n+1);
        
        memo[n][S+sum] = ret;
        return memo[n][S+sum];
    }
}
