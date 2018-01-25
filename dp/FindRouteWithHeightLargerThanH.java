package dp;

//Interview questions from xxx company
public class FindRouteWithHeightLargerThanH {
	public static void main(String[] args){
		System.out.println(find(3, 4, 1));
	}
	
	static int find(int m , int n){
		int[][] dp = new int[m][n];
		dp[m-1][0] = 1;
		for(int j=1;j<n;j++){
			for(int i=0;i<m;i++){
				dp[i][j] = dp[i][j-1] + (i==0?0:dp[i-1][j-1]) + (i==m-1?0:dp[i+1][j-1]);
			}
		}
		return dp[m-1][n-1];
	}
	
	static int find(int m , int n, int h){
		/*int[][][] dp = new int[m][n][2];
		dp[m-1][0][0] = 1;//all accessible
		dp[m-1][0][1] = 0>=h?1:0;//met requirement
		for(int j=1;j<n;j++){
			for(int i=0;i<m;i++){
				dp[i][j][0] = dp[i][j-1][0] + (i==0?0:dp[i-1][j-1][0]) + (i==m-1?0:dp[i+1][j-1][0]);
				if(m-1-i>=h){
					dp[i][j][1] = dp[i][j][0];
				}
				else{
					dp[i][j][1] = dp[i][j-1][1] + (i==0?0:dp[i-1][j-1][1]) + (i==m-1?0:dp[i+1][j-1][1]);
				}
			}
		}
		return dp[m-1][n-1][1];*/
		
		
		int[][] dp = new int[m][2];
		dp[m-1][0] = 1;
		dp[m-1][1] = 0>=h?1:0;
		for(int j=1;j<n;j++){
			int[][] temp = new int[m][2];
			for(int i=0;i<m;i++){
				temp[i][0] = dp[i][0] + (i==0?0:dp[i-1][0]) + (i==m-1?0:dp[i+1][0]);
				if(m-1-i>=h){
					temp[i][1] = temp[i][0];
				}
				else{
					temp[i][1] = dp[i][1] + (i==0?0:dp[i-1][1]) + (i==m-1?0:dp[i+1][1]);
				}
			}
			dp = temp;
		}
		return dp[m-1][1];
	}
	

}
