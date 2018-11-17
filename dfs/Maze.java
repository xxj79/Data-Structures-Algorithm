package dfs;

public class Maze {
	static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfsHelper(maze, start, destination, visited, rows, cols);
    }
    private boolean dfsHelper(int[][] maze, int[] start, int[] destination, boolean[][] visited, int rows, int cols) {
        if (visited[start[0]][start[1]]) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        visited[start[0]][start[1]] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = start[0] + dx[i];
            int nextCol = start[1] + dy[i];
            while (nextRow >= 0 && nextRow < rows && 
                nextCol >= 0 && nextCol < cols && 
                maze[nextRow][nextCol] == 0) {
                nextRow += dx[i];
                nextCol += dy[i];
            }
            nextRow -= dx[i];
            nextCol -= dy[i];
            if (visited[nextRow][nextCol]) continue;
            int[] next = new int[]{nextRow, nextCol};
            if (dfsHelper(maze, next, destination, visited, rows, cols)) {
                return true;
            } 
        }
        return false;
    }
}
