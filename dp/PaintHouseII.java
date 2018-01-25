package dp;

/*
 * The Key is to find the recurrence relation:
 * 
 * For each cell color[i][j], we consider if we are going to paint this cell:
 * dp[i][j] = Math.min(any k!= j| dp[i-1][k]) + costs[i][j]
 * 
 * The idea is similar to the problem Paint House I, for each house and each color, 
 * the minimum cost of painting the house with that color should be the minimum cost 
 * of painting previous houses, and make sure the previous house doesn¡¯t paint with the same color.
 * We can use min1 and min2 to track the indices of the 1st and 2nd smallest cost till previous house, 
 * if the current color¡¯s index is same as min1, then we have to go with min2, otherwise we can safely 
 * go with min1.
 */
public class PaintHouseII {
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);

        int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
        for(int i = 0; i<n; i++) {
            int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
            for(int j = 0; j<k;  j++) {
                int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
                if(minInd< 0) {min = val; minInd = j;}//when min isn't initialized
                else if(val < min) {//when val < min, 
                    secMin = min;
                    min = val;
                    minInd = j;
                } else if(val < secMin) { //when min<=val< secMin
                    secMin = val;
                }
            }
            prevMin = min;
            prevMinInd = minInd;
            prevSecMin = secMin;
        }
        return prevMin;
    }
}
