package twoPointers;

/*
 * classic two pointer technique, similar to remove duplicates
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val){
	int i = -1, j=0;
	while(j<nums.length){
	    if(nums[j]!=val) nums[++i] = nums[j];
	    
	    j++;
	}
	return ++i;
    }
}
