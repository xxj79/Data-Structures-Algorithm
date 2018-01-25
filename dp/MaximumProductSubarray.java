package dp;

/*
 * The idea is actually simple: we need to keep track
 * of both the max and min product we've seen so far, since
 * both of them is possible to produce new max value later.
 * 
 * Once we have that in mind, it's natural to come up with O(n) time
 * and O(1) space dp solution.
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums){
		int max = nums[0], maxToHere = nums[0], minToHere = nums[0];
		for(int i=1;i<nums.length;i++){
			int temp = maxToHere;
			maxToHere = Math.max(Math.max(minToHere*nums[i], maxToHere*nums[i]), nums[i]);
			minToHere = Math.min(Math.min(minToHere*nums[i], temp*nums[i]), nums[i]);
			max = Math.max(maxToHere,  max);
		}
		return max;
	}
}
