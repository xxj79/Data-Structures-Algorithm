package dp;

/*
If k is positive infinity, then there isn¡¯t really any difference between k and k - 1 
(wonder why? see my comment below), which implies 
	T[i-1][k-1][0] = T[i-1][k][0] 
and 
	T[i-1][k-1][1] = T[i-1][k][1]. 
	
Therefore, we still have two unknown variables on each day: T[i][k][0] and T[i][k][1] with k = +Infinity, 
and the recurrence relations say:

T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i]) = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
*/

public class StockInfinityTimes {
	public int maxProfit(int[] prices){
		//0 implies there's no stock in hand, 1 implies we have a stock in hand
		int T_k0 = 0, T_k1 = Integer.MIN_VALUE;
		for(int price : prices){
			int T_k0_old = T_k0;
			T_k0 = Math.max(T_k0, T_k1 + price);
			T_k1 = Math.max(T_k1, T_k0_old - price);
		}
		return T_k0;
	}
}
