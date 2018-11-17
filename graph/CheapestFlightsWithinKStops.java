package graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    //DP(Bellman-Ford)
    final int MAX = 100000000;  
    public int findCheapestPriceDP(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+2];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], MAX);
        dp[src][0] = 0;
        
        for(int i=1;i<=K+1;i++){
            for(int j = 0;j<n;j++) dp[j][i] = dp[j][i-1];
            for(int[] flight : flights){
                dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i-1] + flight[2]);
            }
        }
        return dp[dst][K+1] == MAX ? -1 : dp[dst][K+1];
    }
    
    //1D DP
    public int findCheapestPriceDP1D(int n , int[][] flights, int src, int dst, int K){
        int[] dp = new int[n];
        Arrays.fill(dp, MAX);
        dp[src] = 0;
        
        for(int k = 0;k<=K;k++){
            int[] temp = Arrays.copyOf(dp, n);
            for(int[] flight : flights){
                temp[flight[1]] = Math.min(temp[flight[1]], dp[flight[0]] + flight[2]);
            }
            dp = temp;
        }
        
        return dp[dst] == MAX ? -1 : dp[dst];
    }
    
    //Dijkstra heap, adjancency matrix
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < flights.length; i++) {
            adjacencyMatrix[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        PriorityQueue<City> minHeap = new PriorityQueue<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        minHeap.offer(new City(src, 0, 0));
        cost[src] = 0;
        
        while (!minHeap.isEmpty()) {
            City currentCity = minHeap.poll();
            if(currentCity.id == dst) return currentCity.costFromOrigin;
            
            if (currentCity.stopsFromOrigin - 1 >= K) {
                continue;
            }
            
            int[] nextDirectlyConnectedCities = adjacencyMatrix[currentCity.id];
            
            for (int i = 0; i < n; i++) {
                if (nextDirectlyConnectedCities[i] != 0) {
                    int newCost = currentCity.costFromOrigin + nextDirectlyConnectedCities[i];
                    if (newCost < cost[i]) {
                        minHeap.remove(new City(i));
                        minHeap.offer(new City(i, newCost, currentCity.stopsFromOrigin + 1));
                        cost[i] = newCost;
                    } 
                }
            }           
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    
    private class City implements Comparable<City> {
        int id;
        int costFromOrigin;
        int stopsFromOrigin;
        
        public City(int id) {
            this.id = id;
        }
        
        public City(int id, int costFromOrigin, int stopsFromOrigin) {
            this(id);
            this.costFromOrigin = costFromOrigin;
            this.stopsFromOrigin = stopsFromOrigin;
        }
        
        public boolean equals(Object c) {
            if (c instanceof City) {
                return this.id == ((City)c).id;
            }
            return false;
        }
        
        public int compareTo(City c) {
            return this.costFromOrigin - c.costFromOrigin;
        }
    }
    
    //BFS with queue
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K){
        int[][] graph = new int[n][n];
        for(int[] flight : flights) graph[flight[0]][flight[1]] = flight[2];
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        cost[src] = 0;
        
        while(!q.isEmpty() && K-- >= 0){
            int size = q.size();
            for(int k = 0;k<size;k++){
                int cur = q.poll();
                for(int i = 0; i<n; i++){
                    if(graph[cur][i] > 0 && cost[cur] + graph[cur][i] < cost[i]){
                        cost[i] = cost[cur]+graph[cur][i];
                        q.add(i);
                    }
                }
            }
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    
    //DFS
    int minCost = Integer.MAX_VALUE;
    public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int K){
        int[][] graph = new int[n][n];
        for(int[] flight : flights) graph[flight[0]][flight[1]] = flight[2];
        
        boolean[] visited = new boolean[n];
        findCheapestPrice(graph, visited, src, dst, K, 0);
        
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
    
    private void findCheapestPrice(int[][] graph, boolean[] visited, int src, int dst, int K, int cost){
        if(src == dst) minCost = Math.min(minCost, cost);
        else if(K>=0 && cost < minCost){
            for(int i = 0; i<graph.length; i++){
                if(graph[src][i]!=0 && !visited[i]){
                    visited[i] = true;
                    findCheapestPrice(graph, visited, i, dst, K-1,
                                     cost+graph[src][i]);
                    visited[i] = false;
                }
            }
        }
    }
    
}
