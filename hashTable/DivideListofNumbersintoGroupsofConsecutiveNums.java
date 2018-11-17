package hashTable;

import java.util.*;

public class DivideListofNumbersintoGroupsofConsecutiveNums {
    public static List<List<Integer>> divide(int[] a){
	Map<Integer, Integer> map = new HashMap<>();
	for(int i=0;i<a.length;i++)
	    map.put(a[i], i);
	
	int[] rec = new int[a.length];
	int index = 0;
	for(int n : a){
	    if(map.containsKey(n)){
		add(map, rec, n, index);
		
		int h = n+1, l = n-1;
		while(map.containsKey(h)){
		    add(map, rec, h, index);
		    h++;
		}
		
		while(map.containsKey(l)){
		    add(map, rec, l, index);
		    l--;
		}
		index++;
	    }
	}
	List<List<Integer>> ret = new ArrayList<>();
	for(int i=0;i<index;i++) ret.add(new ArrayList<>());
	
	for(int i=0;i<a.length;i++) ret.get(rec[i]).add(a[i]);
	
	Collections.sort(ret, new Comparator<List<Integer>>(){
	    public int compare(List<Integer> a, List<Integer> b){
		return a.get(0) - b.get(0);
	    }
	});
	return ret;
    }
    
    private static void add(Map<Integer, Integer> map, int[] rec, int n, int index){
	int pos = map.get(n);
	rec[pos] = index;
	map.remove(n);
    }
    
    public static void main(String[] args){
	int[] a = {8,2,4,7,1,0,3,6};
	System.out.println(divide(a));
    }
}
