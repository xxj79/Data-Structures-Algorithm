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
 * 
 * O(nk)
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        
        int min1 = 0, min2 = 0, index1 = -1;
        
        for(int i=0;i<costs.length;i++){
            int m1 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE, idx1 = -1;
            
            for(int j = 0;j<costs[0].length;j++){
        	int cost = costs[i][j] + (j!=index1 ? min1 : min2);
        	
        	if(cost<m1){
        	    m2 = m1;
        	    m1 = cost;
        	    idx1 = j;
        	}
        	
        	else if(cost < m2)
        	    m2 = cost;
            }
            
            min1 = m1;
            min2 = m2;
            index1 = idx1;
        }
        return min1;
    }
}
