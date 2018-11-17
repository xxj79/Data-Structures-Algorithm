package unionFind;

import java.util.*;

/*Leetcode 200. Numbder of Islands
 * Union find
 */

public class NumberOfIsland {
	int count = 0;
	int[] parent, rank;
	public int numIslands(char[][] grid){
	    	if(grid == null || grid.length < 1) return 0;
		int m = grid.length, n = grid[0].length;
		parent = new int[m*n];
		rank = new int[m*n];
		for(int i=0;i<m*n;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		//注意只check右方和下方， 确保一个领边只检查一遍
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] == '0') continue;
				count++;
				int cur = i*n+j;
				int nei;
				if(i<m-1 && grid[i+1][j] == '1'){
					nei =  cur + n;
					union(cur, nei);
				}
				if(j<n-1 && grid[i][j+1] == '1'){
					nei = cur + 1;
					union(cur, nei);
				}
			}
		}
		return count;
	}
	
	private void union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		if(rank[aRoot] > rank[bRoot]) parent[bRoot] = aRoot;
		else if(rank[aRoot] < rank[bRoot]) parent[aRoot] = bRoot;
		else{
			parent[aRoot] = bRoot;
			rank[bRoot]++;
		}
		count--;
	}
	
	private int find(int a){
		return a==parent[a] ? parent[a] : (parent[a] = find(parent[a]));
	}
}
