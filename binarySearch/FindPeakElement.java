package binarySearch;

public class FindPeakElement {
    //注意因为有条件：nums[-1] == nums[len] == -MAX 而且 nums[i] != nums[i+1]
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int m = lo + (hi - lo)/2;
            if(nums[m] > nums[m+1]) hi = m; 
            else lo = m + 1;
        }
        return lo;
    }
}
