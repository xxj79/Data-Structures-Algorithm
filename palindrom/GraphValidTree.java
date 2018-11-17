package palindrom;

import java.util.Arrays;

public class GraphValidTree {
    
    //对所有边进行UF，检查环。确定没环之后可以直接看 edges.length == n - 1 判断是否连接
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}

/*
//DFS: First detect if theres any cycle. Then check if all vertices are visited/connected
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }
        
        return false;
    }
}

  //BFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[][] g = new int[n][n];
        for(int[] e : edges){
            int f = e[0], s = e[1];
            g[f][s] = 1;
            g[s][f] = 1;
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{-1, 0});
        
        while(!q.isEmpty()){
            for(int k = q.size()-1;k>=0;k--){
                int[] cur = q.poll();
                if(visited.contains(cur[1])) return false;
                visited.add(cur[1]);
                for(int i = 0; i < n; i++){
                    if(g[cur[1]][i] == 1 && i!=cur[0]){
                        q.add(new int[]{cur[1], i});
                    }
                }
            }
        }
        
        return visited.size() == n;
    }
}

*/