package graph;

import java.util.*;

public class TopologicalPrintOut {

	//For BFS, similar to Topological Sort, just print out each node into ret array
	
	//This implementation only need an indegree array, but it is average case O(n^2) 
    public int[] findOrderBFS1(int numCourses, int[][] prerequisites) { 
        if (numCourses == 0) return null;
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); 
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
	
	//Another implementatin of BFS, need adj list for the graph.
	//Has worst case O(n^2) better than the above implementation.
    public int[] findOrderBFS2(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        int[] indegree = new int[numCourses];
        for(int[] pair:prerequisites){
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        int count=0;
        for(int i=0;i<numCourses;i++){
            int j=0;
            for(;j<numCourses;j++){
                if(indegree[j]==0)break;
            }
            if(j==numCourses) return new int[0];
            indegree[j] = -1;
            order[count++] = j;
            for(int v:graph.get(j))
                indegree[v]--;
        }
        return order;
    }
	
	//For DFS, we must keep three state to skip visited nodes:
	//(unvisited, being visited, visited) and use a stack to help store
	//nodes from tail back to head.
    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited, new boolean[numCourses])) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    
    private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]) return true;
        if (isLoop[v]) return false;
        isLoop[v] = true;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited, isLoop)) return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }
}
