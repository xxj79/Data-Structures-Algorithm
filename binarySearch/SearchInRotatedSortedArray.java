package binarySearch;

/*
The idea is just add an if statement in normal binary search:

each time we tell which half is sorted, enter the sorted half,
if the target is within the sorted halfs range, adjust the bound
into that half, otherwise we move to the other half
*/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target){
	int l = 0, r = nums.length-1;
	while(l<=r){
	    int m = l+(r-l)/2;
	    if(nums[m] == target) return m;
	    
	    if(nums[l] <= nums[m]){
		if(target<nums[m]&&target>=nums[l]) r = m-1;
		else l = m+1;
	    }
	    else{
		if(target<=nums[r]&& target>nums[m]) l = m+1;
		else r = m-1;
	    }
	}
	return -1;
    }
    
    //Follow up: what if array contains duplicates??
    /*
     * The only difference case would be when
     * nums[left] == nums[mid] == nums[right], where left half
     * could be unsorted, eg: [3, 1, 2, 3, 3, 3, 3]
     * 
     */
    public boolean searchWithDuplicate(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }
}
