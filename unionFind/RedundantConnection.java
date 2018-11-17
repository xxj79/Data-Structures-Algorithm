package unionFind;

public class RedundantConnection {
	/*
	 * LeetCode 684. Redundant Connection
	 */
	
	public int[] findRedundantConnection(int[][] edges){
		int[] parent = new int[2001];
		for(int i=0;i<parent.length;i++) parent[i] = i;
		
		for(int[] edge:edges){
			int from = edge[0], to = edge[1];
			if(find(parent, from) == find(parent, to)) return edge;
			else
				parent[find(parent, to)] = find(parent, from);
		}
		return new int[2];
	}
	
	private int find(int[] parent, int f){
		return f == parent[f] ? f : (parent[f] = find(parent, parent[f]));
	}
}
