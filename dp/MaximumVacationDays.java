package dp;

import java.util.*;

//dp[i][j] stands for the max vacation days we can get in week i staying in city j. 
//It's obvious that dp[i][j] = max(dp[i - 1][k] + days[j][i]) 
//(k = 0...N - 1, if we can go from city k to city j). 
//Also because values of week i only depends on week i - 1, so we can 
//compress two dimensional dp array to one dimension.

public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        
        return max;
    }
}
