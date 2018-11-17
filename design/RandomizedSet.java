package design;

import java.util.*;
import java.util.HashMap;

public class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;
    
    public RandomizedSet(){
	list = new ArrayList<>();
	map = new HashMap<>();
	rand = new Random();
    }
    
    public boolean insert(int val){
	if(map.containsKey(val)) return false;
	
	map.put(val, list.size());
	list.add(val);
	return true;
    }
    
    public boolean remove(int val){
	if(!map.containsKey(val)) return false;
	
	int idx = map.get(val);
	if(idx<list.size() - 1) {
	    int last = list.get(list.size()-1);
	    list.set(idx, last);
	    map.put(last, idx);
	}
	map.remove(val);
	list.remove(list.size()-1);
	return true;
    }
    
    public int getRandom(){
	return list.get(rand.nextInt(list.size()));
    }
}
