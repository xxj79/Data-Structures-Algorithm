package greedy;

/*
 * Greedy ideae, keep an instance of the furthest reachable
 * pos. 
 * 
 * if cur pos is not beyond furthest reachable, we don't
 * update it. Otherwise we update the furthest instance
 */

public class JumpGameII {
    public int jump(int[] nums){
	int step = 0, cur = 0, curEnd = 0, reach = 0;
	//curEnd: furthest we can reach if we don't make
	// a new step
	//reach: furthest we can reach if we take a step
	//from current pos.
	
	for(;cur<nums.length-1;cur++){
	    reach = Math.max(reach, cur+nums[cur]);
	    if(cur == curEnd){
		step++;
		curEnd = reach;
	    }
	}
	return step;
    }
}
