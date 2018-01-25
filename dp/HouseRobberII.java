package dp;

/*
 * Change from a street to a circle, head and end cannot be robbed at the same time
 */
public class HouseRobberII {
	//Take advantage of the robber I solution, add a range restriction to it.
	public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include;
            include = exclude + num[j];
            exclude = Math.max(exclude, i);
        }
        return Math.max(include, exclude);
    }
}
