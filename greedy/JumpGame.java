package greedy;

/*
 * Keep an instance of the furthest we can reach
 * 
 * Then we just walk through and check each position
 * to see if it's reachable while keep updating the 
 * reach instance
 */

public class JumpGame {
    public boolean canJump(int[] nums){
	int reach = 0, cur = 0;
	for(;cur<nums.length;cur++){
	    if(cur > reach) return false;
	    
	    reach = Math.max(reach, cur + nums[cur]);
	}
	return true;
    }
}
