package BFS;

import java.util.*;

public class Maze {
	int[][] dir = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);
        if(maze == null || maze.length<1) return false;
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(Arrays.equals(cur, destination)) return true;
            for(int i=0;i<4;i++){
                int xInc = dir[i][0], yInc = dir[i][1], nextX = x, nextY = y;
                while(nextX>=0 && nextX<m && nextY>=0 && nextY<n && maze[nextX][nextY]==0){
                    nextX+=xInc;
                    nextY+=yInc;
                }
                nextX-=xInc;
                nextY-=yInc;
                if(!visited[nextX][nextY]){
                    q.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
}
