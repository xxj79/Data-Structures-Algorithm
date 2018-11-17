package dfs;

import java.util.*;

/*
 * Leetcode 133. Clone Graph
 */


/*
The key is to use a Map to keep the mapping from value to created node. 
Whether we use dfs or bfs, as long as we have the map which keeps track of 
nodes that we've already created, we can avoid recreating the same nodes.
dfs is easier to code using recursion. Also have a better performance
*/

public class CloneGraph {
	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neightbors;
		UndirectedGraphNode(int x) {
			label = x;
			neightbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return dfs(node, map);
	}
	
	private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
		if(node == null) return null;
		if(map.containsKey(node.label)){
			return map.get(node.label);
		}
		else{
			UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
			map.put(node.label, clone);
			for(int i=0;i<node.neightbors.size();i++){
				clone.neightbors.add(dfs(node.neightbors.get(i),map));
			}
			return clone;
		}
	}
}
