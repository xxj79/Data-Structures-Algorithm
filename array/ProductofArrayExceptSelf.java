package array;


/*
Classic two pass O(n) solution

Use a forward scan to get the product of all elements before the current element;

Then use a backward scan to multiply all elements after the current element;

So we successfully skip the current element by using two passes which skip itself
(cutting the product into two halves)
*/


public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
	int[] ret = new int[nums.length];
	
	for(int i=0, temp = 1;i<nums.length;i++){
	    ret[i]=temp;
	    temp*=nums[i];
	}
	
	for(int i=nums.length-1, temp = 1;i>=0;i--){
	    ret[i]*=temp;
	    temp*=nums[i];
	
	}
	return ret;
    }
}
