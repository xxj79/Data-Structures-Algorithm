package array;

/*
 * The right-most element of the subarray should be the last
 * number that is less than the greatest element before it.
 * 
 * 
 * The left-most elemnt of the subarray should be the last number
 * (scan from right) that is greater than the min element after it.
 */

public class ShortestUnsortedSubarray {
    public int findUnsortedSubarray(int[] A){
	int n = A.length, start = -1, end = -2, min = A[n-1], max = A[0];
	for(int i = 1;i<n;i++){
	    max = Math.max(max, A[i]);
	    min = Math.min(min, A[n-1-i]);
	    
	    if(A[i] <max) end = i;
	    if(A[n-1-i]>min) start = n-1-i;
	}
	
	return end - start + 1;
    }
}
