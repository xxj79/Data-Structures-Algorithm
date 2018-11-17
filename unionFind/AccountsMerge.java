package unionFind;

import java.util.*;
/*
 * Leetcode 721. AccountsMerge
 */

public class AccountsMerge {
	/*
	 * The key task is to connect those emails which is a perfect case for union find
	 * to group these emails, each group need to have a representative/parent
	 * At the beginning, set each email as its own parent
	 * Emails in each account naturally belong to the same group, and should be joined
	 * by assigning to the same parent -- let's use the parent of first email in that list
	 */
	
	public List<List<String>> accountsMerge(List<List<String>> acts){
		Map<String, String> name = new HashMap<>();
		Map<String, String> parent = new HashMap<>();
		Map<String, TreeSet<String>> unions = new HashMap<>();
		
		//Housekeeping stuff, initiating parent map and name map.
		for(List<String> a : acts){
			for(int i=1;i<a.size();i++){
				parent.put(a.get(i), a.get(i));
				name.put(a.get(i), a.get(0));
			}
		}
		
		//Set every emails parent to the first in the list
		for(List<String> a:acts){
			String p = find(a.get(1), parent);
			for(int i=2;i<a.size();i++)
				parent.put(find(a.get(i), parent),p);
		}
		
		//Add every node into the treeset under its parent's name
		for(List<String> a : acts){
			for(int i=1;i<a.size();i++){
				String p = find(a.get(i), parent);
				unions.putIfAbsent(p, new TreeSet<>());
				unions.get(p).add(a.get(i));
			}
		}
		
		//Print out each person's emails, using the name map.
		List<List<String>> ret = new ArrayList<>();
		for(String p:unions.keySet()){
			List<String> emails = new ArrayList(unions.get(p));
			emails.add(0, name.get(p));
			ret.add(emails);
		}
		return ret;
	}
	
	private String find(String s, Map<String, String> p){
		return p.get(s) == s?s:find(p.get(s), p);
	}
	
	
	
	
	
	//Another implementation, more concise
	public List<List<String>> accountsMerge1(List<List<String>> accounts) {
		int[] parents = new int[accounts.size()]; //store which row it belongs to/merge row to row
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < accounts.size(); ++i) {
		    parents[i] = i;
			List<String> account = accounts.get(i);
			for(int j = 1; j < account.size(); ++j) {
				String email = account.get(j);
				if(!map.containsKey(email)) {
					map.put(email, i);
				}
				union(parents, map.get(email), i);
			}
		}
		
		Map<Integer, List<String>> data = new HashMap<>();
		for(String email : map.keySet()) {
			int id = find(parents, map.get(email));
			List<String> list = data.get(id);
			if(list == null) {
				list = new ArrayList<>();
				data.put(id, list);
			}
			list.add(email);
		}
		
		for(int id : data.keySet()) {
			List<String> component = data.get(id);
			Collections.sort(component);
			component.add(0, accounts.get(id).get(0));
		}
		return new ArrayList<List<String>>(data.values());
	}
	
	private void union(int[] parents, int x, int y) {
		int parentX = find(parents, x);
		int parentY = find(parents, y);
		if(parentX != parentY) {
			parents[parentX] = parentY;
		}
	}
	
	private int find(int[] parents, int x) {
		return x == parents[x] ? x : (parents[x] = find(parents, parents[x]));
	}
}
