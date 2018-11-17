package dp;

import java.util.Arrays;

public class WorkingIntervalSalaryEarned {
    public int maxSalary(int[][] works, int time){
	int[] dp = new int[time+1];
	Arrays.sort(works, (a, b) -> (a[1] - b[1]));
	for(int i = 1;i<=time;i++){
	    dp[i] = dp[i-1];
	    for(int[] work : works){
		if(work[1]==i){
		    dp[i] = Math.max(dp[i], dp[work[0]] + work[2]);
		}
	    }
	}
	return dp[time];
    }
    
    public static void main(String[] args){
	WorkingIntervalSalaryEarned obj = new WorkingIntervalSalaryEarned();
	int[][] works = new int[][]{
	    {1, 4, 5},
	    {6, 10, 2},
	    {3, 5, 1},
	    {3, 8, 6},
	    {0, 6, 8},
	    {4, 7, 4},
	    {5, 9, 3},
	    {8, 11, 4}
	};
	System.out.println((obj.maxSalary(works, 11)));
    }
}
