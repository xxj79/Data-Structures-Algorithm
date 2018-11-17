package array;

import java.util.*;


//Use an array as value that stores both frequency and bound indices
public class DegreeOfArray {
    public int findShortestSubArray(int[] nums){
	Map<Integer, int[]> map = new HashMap<>();
	int maxF = 0, ret = Integer.MAX_VALUE;
	for(int i=0;i<nums.length;i++){
	    int[] value = new int[3];
	    if(!map.containsKey(nums[i])){
		value = new int[]{1, i, i};
	    }
	    else{
		value = map.get(nums[i]);
		value[0]++;
		value[2] = i;
	    }
	    maxF = Math.max(maxF, value[0]);
	    map.put(nums[i], value);
	}
	
	for(Map.Entry<Integer, int[]> e : map.entrySet()){
	    int[] cur = e.getValue();
	    if(cur[0] == maxF)
		ret = Math.min(ret, cur[2] - cur[1] + 1);
	}
	return ret;
    }
}
