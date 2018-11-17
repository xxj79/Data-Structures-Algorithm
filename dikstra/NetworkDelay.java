package dikstra;

import java.util.*;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n+1][n+1];
        for(int[] r : g) Arrays.fill(r, -1);
        for(int[] t : times) g[t[0]][t[1]] = t[2];
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> 
        	dis[o1] - dis[o2]);
        
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
