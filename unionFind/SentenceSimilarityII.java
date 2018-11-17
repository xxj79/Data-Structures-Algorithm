package unionFind;

import java.util.*;

/*
 * Leetcode 737. Sentence Similarity II
 * 
 * This is a good use case for Union-Find, compare to Sentence Similarity I, here the
 * similarity betwen words are transitive, so all the connected(similar) words should 
 * be group into an union represented by their ultimate parent.
 * 
 * The connections can be represented by an parent map Map<String, String> m, which 
 * record the direct parentship we learned in each pair, but not the ultimate-parent. 
 * To build it, go throug the input pairs, for each pair<w1, w2), use the recursive 
 * find() method to find the ultimate-parent for bothe words, if they are different,
 * assign parent1 as parent of parent2, so that the two families are merged.  
 */
public class SentenceSimilarityII {
	public boolean areSentencesSimilarTwo(String[] a, String[] b, String[][] pairs){
		Map<String, String> m = new HashMap<>();
		for(String[] p: pairs){
			String parent1 = find(m, p[0]), parent2 = find(m, p[1]);
			if(!parent1.equals(parent2)) m.put(parent1,  parent2);
		}
		
		for(int i=0;i<a.length;i++)
			if(!a[i].equals(b[i]) && !find(m, a[i]).equals(find(m, b[i]))) return false;
		return true;
	}
	
	private String find(Map<String, String> m, String s){
		if(!m.containsKey(s)) m.put(s, s);
		return s.equals(m.get(s)) ? s : find(m, m.get(s));
	}
}













