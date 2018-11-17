package monotonous;

import java.util.*;

/*
 * Thought process:
 * 
 * 1) This is a problem dealing with subarray, it's natural to use prefix
 * sum.
 * 
 * 2) We want some kind of sorting in the solution.
 * 
 * 3) TreeMap could be an option, with index as the values.
 * 
 * 4) Monotonous queue will render a O(N) solution, as we always keep the 
 * indexes in the queue represents prefix sum that is increasing.
 */
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K){
	int N = A.length, ret = N + 1;
	int[] B = new int[N+1];
	for(int i = 0;i<N;i++) B[i+1] = B[i] + A[i];
	Deque<Integer> d = new ArrayDeque<>();
	for(int i = 0;i<N+1;i++){
	    while(d.size() > 0 && B[i] - B[d.getFirst()] >= K) //Check if we can update ret
		ret = Math.min(ret, i - d.poll());
	    while(d.size() > 0 && B[i] <= B[d.getLast()]) d.pollLast(); //Make sure it's mono-increasing
	    
	    d.addLast(i);
	}
	return ret<=N ? ret : -1;
    }
    
    public int shortestSubarrayTreeMap(int[] a, int K){
	if(a.length == 0) return -1;
	TreeMap<Long, Integer> tree = new TreeMap<>();
	long total = 0;
	int ret = Integer.MAX_VALUE;
	for(int i = 0;i < a.length; i++){
	    total += a[i];
	    Long num = tree.floorKey(total - K);
	    if(total <= K) ret = Math.min(ret, i+1); //if first meet a subarray
	    while(num!=null){
		ret = Math.min(ret, i-tree.get(num));
		tree.remove(num);
		num = tree.lowerKey(num);
	    }
	    tree.put(total, i);
	}
	return ret== Integer.MAX_VALUE ? -1 : ret;
    }
}
