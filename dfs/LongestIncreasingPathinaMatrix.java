package dfs;


//Just standard DFS + memoization, scan every element in the matrix
public class LongestIncreasingPathinaMatrix {
    int[] move = {1, 0, -1, 0, 1};
    
    public int longestIncreasingPath(int[][] matrix){
	if(matrix.length == 0) return 0;
	
	int m = matrix.length;
	int n = matrix[0].length;
	
	int[][] cache = new int[m][n];
	int max = 1;
	
	for(int i=0;i<m;i++){
	    for(int j = 0;j<n;j++){
		int len = dfs(matrix, cache, i, j, m, n);
		max = Math.max(max, len);
	    }
	}
	return max;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int i, int j, int m, int n){
	if(cache[i][j] != 0) return cache[i][j];
	
	int len = 1;
	
	for(int k=0;k<4;k++){
	    if(i+move[k]>=0 && i+move[k]<m && j+move[k+1]>=0 && j+move[k+1]<n && matrix[i][j] < matrix[i+move[k]][j+move[k+1]])
		len = Math.max(len, 1+dfs(matrix, cache, i+move[k], j+move[k+1],m, n));
	}
	
	cache[i][j] = len;
	return len;
    }
}
