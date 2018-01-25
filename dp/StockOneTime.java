package dp;

public class StockOneTime {
	//Solution 1: keep track of the lowest price seen so far, use cur price
		// minus it and compare the value with result
		
		public int maxProfit(int[] prices){
			if(prices.length<1) return 0;
			int low = prices[0], ret = 0;
			for(int i=1;i<prices.length;i++){
				ret = Math.max(ret, prices[i] - low);
				low = Math.min(low, prices[i]);
			}
			return ret;
		}
		
		//Kadane's algorithm
		
		public int maxProfit1(int[] prices){
			int maxCur = 0, maxSoFar = 0;
			for(int i=1;i<prices.length;i++){
				maxCur = Math.max(0, maxCur += prices[i]);
				maxSoFar = Math.max(maxCur, maxSoFar);
			}
			return maxSoFar;
		}
		
		//Use the general formula for stock problem:
		/*
		 *  T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
			T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0] - prices[i]) = max(T[i-1][1][1], -prices[i])
		 */
		
		//We can see it's actually the same with ther first solution above
		public int maxProfit2(int[] prices) {
		    int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
		        
		    for (int price : prices) {
		        T_i10 = Math.max(T_i10, T_i11 + price);
		        T_i11 = Math.max(T_i11, -price);//update the lowest prices so far
		    }
		        
		    return T_i10;
		}
}
