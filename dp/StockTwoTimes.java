package dp;

//Similar to the case where k = 1, except now we have four variables instead of two on each day: 
//	T[i][1][0], T[i][1][1], T[i][2][0], T[i][2][1], and the recurrence relations are:
//
//T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
//T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
//T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
//T[i][1][1] = max(T[i-1][1][1], -prices[i])

public class StockTwoTimes {
	public int maxProfit(int[] prices) {
	    int T_i10 = 0, T_i11 = Integer.MIN_VALUE, T_i20 = 0, T_i21 = Integer.MIN_VALUE;
	    
	    for (int price : prices) {
	    	//Notice in this order we don't need any temporary variable
	        T_i20 = Math.max(T_i20, T_i21 + price);
	        T_i21 = Math.max(T_i21, T_i10 - price);
	        T_i10 = Math.max(T_i10, T_i11 + price);
	        T_i11 = Math.max(T_i11, -price);
	    }
	        
	    return T_i20;
	}
}
