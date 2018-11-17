package sort;

import java.util.Random;

/*
 * Quick Select, if not shuffle the input:
 * O(N) best case, O(N^2) worst case.
 * 
 * With randomized input:
 * O(N) guaranteed running time
 */
public class KthSmallestElement {
    public int findKthSmallest(int[] nums, int k){
	shuffle(nums); //avoid worst case, and make time complexity O(n);
	int lo = 0;
	int hi = nums.length-1;
	while(lo<hi){
	    final int j = partition(nums, lo, hi); //Do partition, where j index is index of pivot after partition
	    if(j<k) lo = j+1;
	    else if(j>k) hi = j-1;
	    else break;
	}
	return nums[k];
    }
    
    private void shuffle(int a[]){
	final Random random = new Random();
	for(int ind = 1;ind<a.length;ind++){
	    final int r = random.nextInt(ind+1);
	    swap(a, ind, r);
	}
    }
    
    //This is a very 
    private int partition(int[] a, int lo, int hi){
	int i=lo, j=hi+1;
	while(true){
	    while(i<hi && less(a[++i], a[lo]));
	    while(j>lo && less(a[lo], a[--j]));
	    if(i>=j) break;
	    swap(a, i, j);
	}
	swap(a, lo, j);//swap last smaller element (which is at index j now) with pivot. finishing partitions
	return j;
    }
    
    private void swap(int[] a, int i, int j){
	final int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
    
    private boolean less(int v, int w){
	return v<w;
    }
}
