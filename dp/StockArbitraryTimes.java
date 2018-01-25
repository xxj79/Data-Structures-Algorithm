package dp;

import java.util.*;

/*
 * The key to solve stock problem:
 * 1. Most important thinking -- using two states: 0 or 1 stock in hand;
 * 2. Since sell always comes later than a buy, update sell first (backwards to avoid temporary variables)
 * 3. Only action buy will change the maximum number of transactions allowed , since buy comes before sell
 */
public class StockArbitraryTimes {
	public int maxProfit(int k, int[] prices) {
		
		//Optimize, if k>=n/2, it becomes the same problem when k = infinity
	    if (k >= prices.length >>> 1) {
	        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
	    
	        for (int price : prices) {
	            int T_ik0_old = T_ik0;
	            T_ik0 = Math.max(T_ik0, T_ik1 + price);
	            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
	        }
	        
	        return T_ik0;
	    }
	        
	    int[] T_ik0 = new int[k + 1];
	    int[] T_ik1 = new int[k + 1];
	    Arrays.fill(T_ik1, Integer.MIN_VALUE);
	        
	    //Loop backwards to avoid using update values
	    for (int price : prices) {
	        for (int j = k; j > 0; j--) {
	            T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
	            T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
	        }
	    }
	        
	    return T_ik0[k];
	}
}
