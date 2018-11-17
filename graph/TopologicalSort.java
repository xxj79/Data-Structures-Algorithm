package graph;

import java.util.*;

//Topological sort: 
//	Used to tell whether the graph is a DAG (directed acyclic graph).
//A topologicla ordering is poossible iif the graph has no directed cycles. 

//DFS: O(V+E)
//BFS: O(V^2)

public class TopologicalSort {
	
	/*
	 * 207. Course Schedule. 
	 * Given number of courses and a list of prerequisites info, return whether we can finish
	 * all courses.
	 */
	
	//1.Kahn's algorithm: BFS, keep an record of each node's indegree, starting with those with 0
	//indegree, add to Queue. While we poll a node from Queue, if any other node has an indegree 
	//from node, reduce their indegree by 1. If their indegree becomes 0, add them to queue. If we 
	//cannot iterate through all the nodes, that means this is not a DAG.abstract
	//
	public boolean canFinishUsingKahnBFS(int numCourses, int[][] prerequisites) {
	    int[] indegree = new int[numCourses];
	    List<List<Integer>> courses = new ArrayList<>(numCourses);
	    for(int i=0; i<numCourses; i++) {
		courses.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<prerequisites.length;i++){
		courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
		indegree[prerequisites[i][0]]++;
	    }

	    int count = 0;
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
		if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
		int course = queue.poll();
		count++;
		for(int c : courses.get(course))
		    if(--indegree[c] == 0)
			queue.offer(c);
	    }
	    return count == numCourses;
	}
	
	//Alternative implementation of Kahn's algo, without using Queue, faster:
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    int[] indegrees = new int[numCourses];
	    List<List<Integer>> graph = new ArrayList<>(numCourses);
	    for(int i=0; i<numCourses; i++) {
        	graph.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<prerequisites.length;i++){
		graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		indegrees[prerequisites[i][0]]++;
	    }
	    for(int i=0;i<numCourses;i++){
		int j=0;
		for(;j<numCourses;j++)
		    if(indegrees[j]==0)break;
		if(j==numCourses) return false;
		indegrees[j]=-1;
		for(int neigh:graph.get(j))
		    indegrees[neigh]--;
	    }
	    return true;
	}
	
	//2.DFS: The algorithm loops through each node of the graph, in an arbitrary order, initiating a 
	//DFS that terminates when it hits any node that has already been visited since the beginning of 
	//the topological sort or the node has no outgoing edges.

	public boolean canFinishUsingDFS(int numCourses, int[][] prerequisites){
	    if(numCourses == 0 || prerequisites == null|| prerequisites.length == 0) return true;
		
	    List<List<Integer>> courses = new ArrayList<>(numCourses);
	    for(int i=0; i<numCourses; i++) {
	        courses.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<prerequisites.length;i++){
		courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
	    }
		
	    int[] visited = new int[numCourses]; //For general cases, use a HashMap<Vertex, Integer>
	
	    for(int i=0;i<numCourses;i++){
		if(!dfs(i, courses, visited)) return false;
	    }
	    return true;
	}
	
	private boolean dfs(int course, List<List<Integer>> courses, int[] visited){
	    if(visited[course] == 2) return true; //2 means the nodes all outdegree already explored
	    visited[course] = 1;
		
	    List<Integer> eligibleCourses = courses.get(course);
		
	    for(int i=0;i<eligibleCourses.size();i++){
		int eligibleCourse= eligibleCourses.get(i);
			
		if(visited[eligibleCourse] == 1) return false; //1 means is already met in the current 
		//seaching earlier
		if(visited[eligibleCourse] == 0){
		    if(!dfs(eligibleCourse, courses, visited)) return false;
		}
	    }
	    visited[course] = 2;
	    return true;
	}
	
	
	/*
	 * 444. Sequence Reconstruction
	 * Tricky
	 */
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        //Following part is very useful to construct graph and indegree for arrays like this. 
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<Integer>());
                indegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    graph.get(seq.get(i-1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) { //if more than 1 element has 0 indgree, that means there are more than 1 possibility of reconstructed result, which should return false!!!
                return false;
            }
            int curr = q.poll();
            if (org[index++] != curr) { // Check if reconstructed result match the sequence in org
                return false;
            }
            for (int nb : graph.get(curr)) {    // adjust the indegree table
                indegree.put(nb, indegree.get(nb) - 1);
                if (indegree.get(nb) == 0) {
                    q.add(nb);
                }
            }
        }
        return index == org.length; //if reach the end of org, we succeed
    }
	
}
