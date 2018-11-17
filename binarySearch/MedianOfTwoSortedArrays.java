package binarySearch;

/*
 * partition two arrays, and make sure the min element on the 
 * right side of array A is no less than max element on the left 
 * side of array B
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
	int n1 = nums1.length;
	int n2 = nums2.length;
	
	if(n1>n2) return findMedianSortedArrays(nums2, nums1);
	
	int k = (n1+n2+1)/2; // ע�⣺+1 handles both odd and even case.
	
	int l = 0, r = n1; // ע�⣺ l and r are places to cut, so it goes from 0 to n1
	while(l<r){
	    int m1 = l + (r-l)/2;
	    int m2 = k - m1;
	    if(nums1[m1] < nums2[m2-1])
		l = m1+1;
	    else
		r = m1;
	}
	int m1=l;
	int m2=k-l;
	
	int c1=Math.max(m1<=0?Integer.MIN_VALUE:nums1[m1-1],
		m2<=0?Integer.MIN_VALUE:nums2[m2-1]);
	if((n1+n2)%2 == 1) return c1;
	
	int c2 =Math.min(m1>=n1?Integer.MAX_VALUE:nums1[m1],
		m2>=n2?Integer.MAX_VALUE:nums2[m2]);
	return (c1+c2)/2.0;
    }
}
