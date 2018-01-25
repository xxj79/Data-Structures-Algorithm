package dp;

import java.util.*;


/*
 * Classic knapsack problem!!! Since just two equal subsets, we only need to 
 * consider whether we can reach sum/2 or not. Construct an array dp[sum]
 * 
 * dp[i] = previous dp[i] --> not use current
 * 
 * dp[i] = previous dp[i-num] --> use current
 */
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        //For every number, traverse the whole range (sum-number itself) to see
        //what value can we achieve by adding this number
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
            	dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[sum];
    }
    
	//Non-optimized version
	public boolean canPartition1(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;

	    int n = nums.length;
	    boolean[][] dp = new boolean[n+1][sum+1];
	    for (int i = 0; i < dp.length; i++) {
	        Arrays.fill(dp[i], false);
	    }
	    
	    for (int i = 0; i < n+1; i++) {
	        dp[i][0] = true;
	    }
	    
	    for (int i = 1; i < n+1; i++) {
	        for (int j = 1; j < sum+1; j++) {
	            dp[i][j] = dp[i-1][j];
	            if (j >= nums[i-1]) {
	                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	            }
	        }
	    }
	   
	    return dp[n][sum];
	}
}
