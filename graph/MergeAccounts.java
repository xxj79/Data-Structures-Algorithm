package graph;

import java.util.*;

/*
 * Leetcode 721. Accounts Merge
 */
public class MergeAccounts {

	//DFS or BFS
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // build the graph
        Map<String,Set<String>> graph=new HashMap<>();
        for(List<String> ls:accounts){
            for(int i=1;i<ls.size();i++){
                graph.putIfAbsent(ls.get(i),new HashSet<String>());
                if(i==1) continue;
                graph.get(ls.get(i-1)).add(ls.get(i));
                graph.get(ls.get(i)).add(ls.get(i-1));
            }
        }
        
        // traverse the graph, find out all the connected subgraph
        Set<String> visited=new HashSet<>();
        List<List<String>> result=new ArrayList<>();
        for(List<String> ls:accounts){
                if(!visited.contains(ls.get(1))){ //Only need to check one of them, since we do a dfs here!!!
                    List<String> ans=new ArrayList<>();
                    dfs(graph,visited,ls.get(1),ans); 
                    Collections.sort(ans);
                    ans.add(0,ls.get(0));
                    result.add(ans);
                }
        }
        return result;
    }
    
    public void dfs(Map<String,Set<String>> graph, Set<String> visited, String s,List<String> ans){
        ans.add(s);
        visited.add(s);
        for(String str:graph.get(s)){
            if(!visited.contains(str)){
                dfs(graph,visited,str,ans);
            }
        }
    }
    
    //BFS just a different traverse technique
    public void bfs(Map<String,Set<String>> graph, Set<String> visited, String s,List<String> ans){
        Queue<String> q=new LinkedList<>();
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
            String t=q.poll();
            ans.add(t);
            for(String str:graph.get(t)){
                if(!visited.contains(str)){
                    q.add(str);
                    visited.add(str);
                } 
            }
        }
    }
}
