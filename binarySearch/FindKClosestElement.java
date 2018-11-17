package binarySearch;

import java.util.*;

public class FindKClosestElement {
  //Smarter and trickier way:
    /*
    binary-search for where the resulting elements start in the array. 
    It’s the first index i so that arr[i] is better than arr[i+k] 
    (with “better” meaning closer to or equally close to x). 
    Then just return the k elements starting there.
    */
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x) //找到窗口开始的index，应该满足   x - arr[ind] <= arr[ind+k] - x
                lo = mid + 1;
            else
                hi = mid;
        }
        List<Integer> ret = new ArrayList<>();
        for(int a : arr) ret.add(a);
        return ret.subList(lo, lo + k);
    }
    
    
    
    public List<Integer> findClosestElements1(int[] arr, int k, int x){
	//find the first element >= target.
	int l = 0, r = arr.length-1;
	while(l<r){
	    int m = (l+r)/2;
	    if(arr[m]<x) l = m+1;
	    else r = m;
	}
	int index = l;
	
	//expand from index and index-1
	int i = index - 1, j = index;
	
	while(k-->0){
	    if(i<0 || (j<arr.length && Math.abs(arr[i]-x)>Math.abs(arr[j] - x))) j++;
	    else i--;
	}
	List<Integer> ret = new ArrayList<>();
	for(int a : arr) ret.add(a);
	
	return ret.subList(i+1, j);
    }
}
