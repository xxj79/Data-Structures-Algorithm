package graph;

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(String[][] tickets){
	path = new LinkedList<>();
	flights = new HashMap<>();
	
	for(String[] ticket : tickets){
	    flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
	    flights.get(ticket[0]).add(ticket[1]);
	}
	
	dfs("JFK");
	return path;
    }
    
    private void dfs(String city){
	while(flights.get(city)!=null && !flights.get(city).isEmpty()){
	    String neighbor = flights.get(city).poll();
	    dfs(neighbor);
	}
	path.addFirst(city);
    }
}
