package Math;

public class NextPermutation {
    /*
     * Find the logic is the key:
     * 
     * 1)We need to find the rightmost increasing pairs
     * 2)We need to find the rightmost element that's bigger than the 
     * ankle element, and swap them two
     * 
     * 3) reverse the part to the right of that element
     */
    
    public void nextPermutation(int[] nums){
	int i = nums.length - 2;
	while(i>=0 && nums[i+1] <= nums[i]) i--;
	
	if(i>=0){
	    int j=nums.length-1;
	    while(j>=0 && nums[j]<=nums[j]) j--;
	    
	    swap(nums, i, j);
	}
	reverse(nums, i+1);
    }
    
    void reverse(int[] nums, int start){
	int i=start, j=nums.length-1;
	while(i<j){
	    swap(nums, i, j);
	    i++;
	    j--;
	}
    }
    
    void swap(int[] nums, int i, int j){
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }
}
