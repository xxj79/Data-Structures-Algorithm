package design;

import java.util.*;

public class LRUwithLinkedHashMap {
    int size, num;
    Map<Integer, Integer> map;
    
    public LRUwithLinkedHashMap(int capacity){
	size = capacity;
	List list  = new LinkedList();
	map = new LinkedHashMap<>();
    }
    
    public int get(int key){
	if(map.containsKey(key)){
	    int value = map.get(key);
	    map.remove(key);
	    map.put(key, value);
	    return value;
	}
	else 
	    return -1;
    }
     public void put(int key, int value){
	 if(map.containsKey(key)){
	     map.remove(key);
	     map.put(key, value);
	 }
	 else{
	     if(num == size){
		 int firstKey = map.keySet().iterator().next();
		 map.remove(firstKey);
		 map.put(key, value);
	     }
	     else{
		 map.put(key, value);
		 num++;
	     }
	 }
	 
     }
}
