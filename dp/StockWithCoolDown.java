package dp;

/*
T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
 */
public class StockWithCoolDown {
	public int maxProfit(int[] prices) {
	    int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
	    
	    for (int price : prices) {
	        int T_ik0_old = T_ik0; //Cache the previous state
	        T_ik0 = Math.max(T_ik0, T_ik1 + price);
	        T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
	        T_ik0_pre = T_ik0_old; //Grab the previous state to use in next loop
	    }
	    
	    return T_ik0;
	}
}
