package binarySearch;

public class SearchForARange {
    /*
     * Two binary search, to find left and right
     * edge respectively.
     * 
     * Notice to find the right edge, we make the middle
     * pivot biased to the right to avoid stuck!!!
     */
    
    public int[] searchRange(int[] nums, int target){
	int l = 0, h = nums.length-1;
	if(nums == null || nums.length<1) return new int[]{-1,-1};
	int[] ret = new int[]{-1,-1};
	
	while(l<h){
	    int m = l+(h-l)/2;
	    if(nums[m]<target) l =m+1;
	    else h= m;
	}
	
	if(nums[l]!=target) return ret;
	ret[0] = l;
	
	h = nums.length-1;
	while(l<h){
	    int m = l+(h-l)/2+1; //Key point!!! Biased to the right!!
	    if(nums[m]>target) h = m-1;
	    else l = m;  //So here we can avoid being stuck
	}
	ret[1] = h;
	
	return ret;
    }
}
