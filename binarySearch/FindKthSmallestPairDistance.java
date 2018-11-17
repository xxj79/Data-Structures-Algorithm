package binarySearch;

import java.util.Arrays;

/*
 * Range based binary search, find and count position.
 * 
 * With a little trick, need to use two pointers to count.
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k){
	if(nums == null||nums.length == 0) return 0;
	
	Arrays.sort(nums);
	
	int lo = 0, hi = nums[nums.length - 1] -nums[0];
	
	while(lo<hi){
	    int mid = lo + (hi - lo)/2;
	    
	    //Two pointers trick!!
	    int count = 0, left = 0;
	    
	    for(int right = 1;right < nums.length;right++){
		while(nums[right]-nums[left]>mid){
		    left++;
		}
		count += right-left;
	    }
	    if(count<k) lo = mid+1;
	    else hi = mid;
	}
	return lo;
    }
}
