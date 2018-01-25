package dp;

public class OutOfBoundaryPaths {
    /*
     * Bottom up DP
     * Reccurrence relation: dp[i][j][N] = dp[in][jn][N-1] 
     * in,jn stands for adjacent celss around i,j
     * 
     * below is the 2d space optimized version.
     */
    
    public int findPaths(int m, int n, int N, int i, int j) {
	long[][] dp = new long[50][50];
	for (int Ni = 1; Ni <= N; ++Ni){
	    long[][] temp = new long[50][50];
	    for (int mi = 0; mi < m; ++mi){
		for (int ni = 0; ni < n; ++ni)
		    temp[mi][ni] = ((mi == 0 ? 1 : dp[mi - 1][ni]) + (mi == m - 1? 1 : dp[mi + 1][ni])
	                + (ni == 0 ? 1 : dp[mi][ni - 1]) + (ni == n - 1 ? 1 : dp[mi][ni + 1])) % 1000000007;
	    }
	    dp = temp; 
	}
	return (int)dp[i][j];
    }
    
    /*
     * Memoization approach, without the optimization/early termination, it would get TLE.
     * 
     * With optimization, it has good performance.
     */
    public int findPaths1(int m, int n, int N, int i, int j) {
        int[][][] max=new int[m][n][N+1];
        return dfs(max,i,j,N)%1000000007;
        
    }
    private final static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int dfs(int[][][] mat, int x, int y, int step){
        if(x<0 || y<0 || x>=mat.length || y>=mat[0].length) return 1;
        
        //Optimization!!!!
        if (x-step>=0 && x+step<mat.length && y-step>=0 && y+step<mat[0].length)  return 0;
        
        if(step<=0) return 0;
        if(mat[x][y][step]>0) return mat[x][y][step];
        int count = 0;
        for(int[] dir : dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            count += dfs(mat, i, j, step-1)%1000000007; //Notice these two lines, every time doing a addition we do the module, to avoid overflow.
            count %= 1000000007;
        }
        mat[x][y][step] = count;
        return count;
    }
}
