package BFS;

import java.util.*;

public class PacificAtlanticWaterFlow {
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix){
	List<int[]> ret = new ArrayList<>();
	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
	
	int n = matrix.length, m = matrix[0].length;
	
	//Notice here the boolean array serves as both visited as well as canReach
	boolean[][] pacific = new boolean[n][m];
	boolean[][] atlantic = new boolean[n][m];
	
	Queue<int[]> pQ = new LinkedList<>();
	Queue<int[]> aQ = new LinkedList<>();
	
	for(int i=0;i<n;i++){
	    pQ.add(new int[]{i, 0});
	    aQ.add(new int[]{i, m-1});
	    pacific[i][0] = true;
	    atlantic[i][m-1] = true;
	}
	
	for(int i=0;i<m;i++){
	    pQ.add(new int[]{0,i});
	    aQ.add(new int[]{n-1, i});
	    pacific[0][i] = true;
	    atlantic[n-1][i] = true;
	}
	
	bfs(matrix, pQ, pacific);
	bfs(matrix, aQ, atlantic);
	
	for(int i=0;i<n;i++){
	    for(int j=0;j<m;j++){
		if(pacific[i][j] && atlantic[i][j])
		    ret.add(new int[]{i,j});
	    }
	}
	return ret;
    }
    
    private void bfs(int[][] matrix, Queue<int[]> q, boolean[][] visited){
	int n = matrix.length, m = matrix[0].length;
	while(!q.isEmpty()){
	    int[] cur = q.poll();
	    for(int[] d : dir){
		int x = cur[0] + d[0];
		int y = cur[1] + d[1];
		if(x<0 || x>=n||y<0||y>=m||visited[x][y] ||matrix[x][y]<matrix[cur[0]][cur[1]]){
		    continue;
		}
		visited[x][y] = true;
		q.add(new int[]{x, y});
	    }
	}
    }
}
