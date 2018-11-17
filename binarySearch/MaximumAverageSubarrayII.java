package binarySearch;

public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k){
	double l = -10000, r = 10000;
	while(r - l > 10e-7){
	    double mid = (l+r)/2;
	    if(getMaxSubarraySumOfSizeK(nums, k, mid)>=0) l = mid;
	    else r = mid;
	}
	return (l+r)/2;
    }
    
    public double getMaxSubarraySumOfSizeK(int[] nums, int k, double mid){
	double sum = 0.0;
	for(int i=0;i<nums.length-1;i++) sum+= nums[i] -mid;
	
	double maxSum = sum, prev = nums[0]-mid;
	
	for(int i=k;i<nums.length;i++){
	    sum = sum - nums[i-k] + nums[i];
	    maxSum = Math.max(maxSum, Math.max(sum, sum+prev));
	    prev = Math.max(nums[i-k+1], nums[i-k+1]+prev) - mid;
	}
	return maxSum;
    }
}
