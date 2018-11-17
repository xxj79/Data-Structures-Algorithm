package graph;

import java.util.*;

class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
	return dfs(node, new HashMap<>());
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
	if(node == null) return null;
	if(map.containsKey(node.label)){
	    return map.get(node.label);
	}else{
	    UndirectedGraphNode clone = new UndirectedGraphNode (node.label);
	    map.put(node.label, clone);
	    for(UndirectedGraphNode neighbor : node.neighbors){
		clone.neighbors.add(dfs(neighbor, map));
	    }
	    return clone;
	}
    }
}
