package twoPass;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
	int n = nums.length;
	int[] ret = new int[n];
	
	for(int i = 0, left = 1; i < n; i++){
	    ret[i] = left;
	    left *= nums[i];
	}
	
	for(int i = n-1, right = 1; i>=0; i--){
	    ret[i] *= right;
	    right *= nums[i];
	}
	return ret;
    }
}
