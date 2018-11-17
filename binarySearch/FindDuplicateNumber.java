package binarySearch;

/*
 * Leetcode 287
 * An example of using range-based binary search
 * 
 * Basic idea is: 
 * 1) find min and max value
 * 2) binary search the mid
 * 3) count the position of mid value
 * 4) update pointer based on the result in step 3
 */

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums){
	int l = 1, r = nums.length - 1;
	while(l<r){
	    int m = l+(r-l)/2;
	    int count = 0;
	    for(int n : nums){
		if(n <= m) count++;
	    }
	    if(count>m) r = m;
	    else l = m+1;
	}
	return l;
    }
}
