package twoPointers;

/*
 * classic two pointers problem
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums){
	if(nums.length<1) return 0;
	
	int cur = 0;
	for(int i = 1;i<nums.length;i++){
	    if(nums[i]>nums[cur]){
		nums[++cur] = nums[i];
	    }
	}
	return cur+1;
    }
}
