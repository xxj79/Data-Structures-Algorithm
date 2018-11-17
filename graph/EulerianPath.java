package graph;

import java.util.*;
//Traverse the graph while visiting each node exactly once “ª± ª≠Œ Ã‚

/*
 * LeetCode 322. Reconstruct Itinerary
 */

public class EulerianPath {

	//Given a list of [depart, arrive], reconstruct the itinerary with smallest
	//lexi order.
	
	
	
	//Use Min Heap, make sure always poll the smallest string first, larger string will be 
	//polled in later recursive call. And we need to write down the path backwards while retreating!!!
    
    	//Using min heap is basically the same idea as Dijkstra algorithm
	
	Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(String[][] tickets) {
        path = new LinkedList<>();
        flights = new HashMap<>();
        for(String[] ticket : tickets){
            flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }
    
    void dfs(String city){
        
        while(flights.get(city)!=null && !flights.get(city).isEmpty()){
            String neighbor = flights.get(city).poll();
            dfs(neighbor);
        }
        path.addFirst(city);
    }
}
