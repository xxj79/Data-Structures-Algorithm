package dikstra;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
	int[][] g = new int[n][n];
	for(int[] f : flights)
	    g[f[0]][f[1]] = f[2];
	
	Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
	    public int compare(int[] a, int[] b){
		return a[0] - b[0];
	    }
	});
	
	pq.add(new int[]{0, src, k+1});
	while(!pq.isEmpty()){
	    int[] cur = pq.poll();
	    int p = cur[0], city = cur[1], s = cur[2];
	    if(city == dst) return p;
	    if(s > 0){
		for(int i = 0;i<n;i++){
		    if(g[city][i] != 0)
			pq.add(new int[]{p + g[city][i], i, s - 1});
		}
	    }
	}
	return -1;
    }
}
