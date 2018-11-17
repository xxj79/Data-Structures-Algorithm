package twoPointers;

//Use every element as right end, locate the left end that form 
//the longest subarray end with right end, count+= right-left+1
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k){
	int l=0, r=0, count=0, p=1, n=nums.length;
	while(r<n && p<k){
	    p*=nums[r];
	    while(l<=r && p>=k){
		p/=nums[l++];
	    }
	    count+=r++-l+1;
	}
	return count;
    }
}
