package twoPointers;

//Classic two end pointer problem

//The tricky part here is for each end value, we need to 
//keep the soFarMax value of it, and use the min of two end 
//as the current h.
//Then move the two pointers according to their comparison 
//relationship with h.

public class TrappingRainWater {
    public int trap(int[] A){
	int l = 0, r = A.length-1;
	int leftMax = 0, rightMax = 0, ret = 0;
	while(l<r){
	    leftMax = Math.max(leftMax, A[l]);
	    rightMax = Math.max(rightMax, A[r]);
	    int h = Math.min(leftMax, rightMax);
	    while(l<r && A[l]<=h) ret += h-A[l++];
	    while(l<r && A[r]<=h) ret += h-A[r--];
	}
	return ret;
    }
}
