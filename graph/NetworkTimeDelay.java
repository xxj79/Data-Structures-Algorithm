package graph;

import java.util.*;

public class NetworkTimeDelay {
    //Bellman-ford, easy
    //O(VE)
    final int MAX = 100000000;
    public int networkDelayTimeDP(int[][] times, int N, int K) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[K] = 0;
        
        for(int i = 1; i<N; i++){
            for(int[] time : times){
                if(dist[time[1]] > dist[time[0]] + time[2])
                    dist[time[1]] = dist[time[0]] + time[2];
            }
        }
        int ret = 0;
        for(int i = 1; i<= N ;i++){
            ret = Math.max(ret, dist[i]);
        }
        return ret == MAX ? -1 : ret;
    }
    
    //BFS
    //O(V^V) with prunning
    public int networkDelayTimeBFS(int[][] times, int N, int K) {
        int[] delay = new int[N + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        Integer[][] edge = new Integer[101][101]; //Integer type, easy to check for null
        for (int[] e : times) edge[e[0]][e[1]] = e[2];
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        delay[K] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            
            /*
             * 
            // Below is bad, cause in the notification it tells us that this is a dense graph
            //where E is much larger than V, we would rather iterate all the vertices
            
            for(int[] time : times){
                if(time[0] == u && delay[u] + time[2] < delay[time[1]]){
                    q.offer(time[1]);
                    delay[time[1]] = delay[time[0]] + time[2];
                }
            }*/
            
            for (int v = 1; v <= 100; v++) {
                if (edge[u][v] != null && delay[u] + edge[u][v] < delay[v]) {
                    q.offer(v);
                    delay[v] = delay[u] + edge[u][v];
                }
            }
            
        }
        int maxdelay = 0;
        for (int i = 1; i <= N; i++)
            maxdelay = Math.max(maxdelay, delay[i]);

        return maxdelay == Integer.MAX_VALUE ? -1 : maxdelay;
    }
    
    //Dijkstra
    //O(E + VlgV)
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n+1][n+1];
        for(int[] r : g) Arrays.fill(r, -1);
        for(int[] t : times) g[t[0]][t[1]] = t[2];
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return dis[a] - dis[b];
            }
        });
        
        pq.add(k);
        while(!pq.isEmpty()){
            int node = pq.poll(), d = dis[node];
            for(int i = 1;i<=n;i++){
                if(g[node][i] != -1 && d + g[node][i] < dis[i]){
                    dis[i] = d + g[node][i];
                    pq.add(i);
                }
            }
        }
        
        int ret = 0;
        for(int i = 1; i<=n;i++) ret = Math.max(ret, dis[i]);
        return ret == Integer.MAX_VALUE?-1:ret;
    }
}
