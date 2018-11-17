package hashTable;

import java.util.*;

public class LongestConsecutiveSequences {
    public int lonestConsecutive(int[] nums){
	Set<Integer> set = new HashSet<>();
	for(int n:nums) set.add(n);
	
	int ret = 0;
	for(int n:nums){
	    if(!set.contains(n-1)){
		int m = n+1;
		while(set.contains(m)) m++;
		ret = Math.max(ret, m-n);
	    }
	}
	return ret;
    }
}
