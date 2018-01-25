package dp;

import java.util.*;

/*
 * Actually a LIS problem, sort the width first
 * 
 */
public class RussianDoll {
//	Sort the array. 
//	***Ascend on width and descend on height if width are same***!!! (A little tricky)
//	Find the longest increasing subsequence based on height. (Since width is already sorted)
	public int maxEnvelopes(int[][] envelopes){
		if(envelopes == null || envelopes.length == 0 
			       || envelopes[0] == null || envelopes[0].length != 2)
			        return 0;
		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] a1, int[] a2){
				return a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0];
			}
		});
		
		int[] dp = new int[envelopes.length];
		int len = 0;
		for(int[] envelope: envelopes){
			int i = 0, j = len;
			while(i!=j){
				int m = i+(j-i)/2;
				if(dp[m]<envelope[1]) i = m+1;
				else j = m;
			}
			//int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			//if(index < 0)
			//	 index = -(index + 1);
			dp[i] = envelope[1];
			if(i==len) len++;
		}
		return len;
	}
	
	//O(n^2) naive dp solution
	public int maxEnvelopes1(int[][] envelopes) {
	    if (   envelopes           == null
	        || envelopes.length    == 0
	        || envelopes[0]        == null
	        || envelopes[0].length == 0){
	        return 0;    
	    }
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        @Override
	        public int compare(int[] e1, int[] e2){
	            return e1[0] - e2[0];
	        }
	    });
	    int   n  = envelopes.length;
	    int[] dp = new int[n];
	    int ret = 0;
	    for (int i = 0; i < n; i++){
	        dp[i] = 1;
	        for (int j = 0; j < i; j++){
	            if (   envelopes[i][0] > envelopes[j][0]
	                && envelopes[i][1] > envelopes[j][1]){
	                dp[i] = Math.max(dp[i], 1 + dp[j]);    
	            }
	        } 
	        ret = Math.max(ret, dp[i]);
	    }
	    return ret;
	}
}
