package dp;

public class HouseRobberI {
	//Easy O(n) space
	public int rob(int[] nums){
		int n = nums.length;
		if(nums == null || nums.length<1) return 0;
		if(nums.length<2) return nums[0];
		int[] dp = new int[n+1];
		for(int i=1;i<n;i++){
			dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
		}
		return dp[n];
	}
	
	//Note dp[i+1] only depends on dp[i] and dp[i-1], we can reduce the space
	//complexity to O(1)
	public int rob1(int[] nums){
		int n = nums.length, ex = 0, in = 0;
		for(int i=0;i<n;i++){
			int inOld = in;
			in = ex + nums[i];
			ex = Math.max(inOld, ex);
		}
		return Math.max(in, ex);
	}
}
