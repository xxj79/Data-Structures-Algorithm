package dp;

public class MaximumSubarray {
	public int maxSubArrayDP(int[] nums){
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int ret = dp[0];
		for(int i=0;i<nums.length;i++){
			dp[i] = nums[i] + (dp[i-1]>0 ? dp[i-1] : 0);
			ret = Math.max(ret, dp[i]);
		}
		return ret;
	}
	
	//O(1)space version
	public int maxSubArray(int[] nums) {
        int max = nums[0]  , cur = nums[0];
        for(int i=1;i<nums.length;i++){
            cur = Math.max(cur+nums[i], nums[i]);
            max= Math.max(max, cur);
        }
        return max;
    }
}
