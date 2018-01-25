package dp;

//Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//Output: 4
//
//Explanation: This are totally 4 strings can be formed by the using of 5 0s 
//and 3 1s, which are ¡°10,¡±0001¡±,¡±1¡±,¡±0¡±

/*
 * knapsack problem:
 * 
 * Iterate through elements in the collection, for each element, scan the dp
 * array backwards(from sum to 1), use || not use.
 * 
 * The only tricky part may be for this problem we need a 2D dp array.
 */
public class OnesAndZeros {
	public int findMaxForm(String[] strs, int m, int n){
		int[][] dp = new int[m+1][n+1];
		for(String s:strs){
			int[] count = count(s);
			for(int i=m;i>=count[0];i--)
				for(int j=n;j>=count[1];j--)
					dp[i][j] = Math.max(1+dp[i-count[0]][j-count[1]],dp[i][j]);
		}
		return dp[m][n];
	}
	
	public int[] count(String str){
		int[] ret = new int[2];
		for(int i=0;i<str.length();i++){
			ret[str.charAt(i) - '0']++;
		}
		return ret;
	}
}
