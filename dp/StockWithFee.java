package dp;

/*
T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i] - fee)
 */
public class StockWithFee {
	public int maxProfit(int[] prices, int fee) {
	    int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
	    
	    for (int price : prices) {
	        int T_ik0_old = T_ik0;
	        T_ik0 = Math.max(T_ik0, T_ik1 + price);
	        T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
	    }
	        
	    return T_ik0;
	}
}
