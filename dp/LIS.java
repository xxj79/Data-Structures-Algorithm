package dp;

/*
 * Longest Increasing Subsequence problem
 */
public class LIS {
	//The best solution uses binary search to update the tail array
	//O(nlogn)
	public int lengthOfLIS(int[] nums){
		int[] tails = new int[nums.length];
		int size = 0;
		for(int x : nums){
			int i=0, j=size;
			while(i!=j){
				int m = i+(j-i)/2;
				if(tails[m]<x)
					i = m+1;
				else 
					j = m;
			}
			//Or use the API for binary search part
			/*
			int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            */
			tails[i] = x;
			if(i == size) ++size;
		}
		return size;
	}
	
	//Naive O(n^2) dp approach
	public int lengthOfLIS1(int[] nums){
        if(nums.length<=1) return nums.length;
        
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++)    dp[i] = 1;
        int ret = 0;
        
        for(int i=1;i<dp.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        
        return ret;
    }
}
