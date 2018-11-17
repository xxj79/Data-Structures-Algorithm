package hashTable;

import java.util.*;

public class ShortestWordDistanceII {
    Map<String, List<Integer>> map;
    
    public ShortestWordDistanceII(String[] words){
	map = new HashMap<>();
	for(int i = 0;i<words.length;i++){
	    if(!map.containsKey(words[i])){
		List<Integer> list = new ArrayList<>();
		list.add(i);
		map.put(words[i], list);
	    }
	    else
		map.get(words[i]).add(i);
	}
    }
    
    public int shortest(String word1, String word2){
	List<Integer> l1 = map.get(word1);
	List<Integer> l2 = map.get(word2);
	int i1 = 0, i2 = 0, ret = Integer.MAX_VALUE;
	while(i1 < l1.size() && i2 < l2.size()){
	    int pos1 = l1.get(i1), pos2 = l2.get(i2);
	    ret = Math.min(ret, Math.abs(pos1 - pos2));
	    if(pos1 < pos2) i1++;
	    else i2++;
	}
	return ret;
    }
}
