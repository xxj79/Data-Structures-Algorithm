package dfs;

import java.util.*;

public class PacificAtlanticWaterFlow {
    
    public List<int[]> pacificAtlantic(int[][] matrix){ 
        List<int[]> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        
        int n = matrix.length, m = matrix[0].length;
        
        //Notice the visited set also is the canReach set
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic=  new boolean[n][m];
        
        for(int i=0;i<n;i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        
        for(int i=0;i<m;i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
        	if(pacific[i][j] && atlantic[i][j])
        	    ret.add(new int[]{i, j});
            }
        }
        return ret;
    }
    
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){
	int n = matrix.length, m = matrix[0].length;
	
	if(x<0 || x>=n ||y<0 || y>=m|| visited[x][y] || matrix[x][y]<height) return;
	
	visited[x][y] =  true;
	
	for(int[] d : dir)
	    dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
    }
}
