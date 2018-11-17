package unionFind;
import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{9, 5, 7, 6, 3, 1, 4};
		System.out.println(longestConsecutive(a));
	}

	public static int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // <value,index>
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)){
                uf.union(i,map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
                uf.union(i,map.get(nums[i]-1));
            }
        }
        return uf.maxUnion();
    }
	
	static class UF{
	    private int[] list, rank;
	    public UF(int n){
	        list = new int[n];
	        rank = new int[n];
	        for(int i=0; i<n; i++){
	            list[i] = i;
	        }
	    }

	    private int root(int i){
	        if(i!=list[i]){
	            list[i] = root(list[i]); //recursion path compression
	        }
	        
	        /*	// grandparent path compression	
	        while(i!=list[i]){
	            list[i] = list[list[i]];
	            i = list[i];
	        }
	        */
	        return list[i];
	    }

	    public boolean connected(int i, int j){
	        return root(i) == root(j);
	    }

	    public void union(int p, int q){
	      int i = root(p);
	      int j = root(q);
	      if(i==j) return;
	      if(rank[i]>rank[j]) list[j] = i;
	      else{
	    	  list[i] = j;
	    	  if(rank[i] == rank[j]) rank[j]++;
	      }
	    }

	    // returns the maxium size of union
	    public int maxUnion(){ // O(n)
	        int[] count = new int[list.length];
	        int max = 0;
	        for(int i=0; i<list.length; i++){
	            count[root(i)] ++;
	            max = Math.max(max, count[root(i)]);
	        }
	        return max;
	    }
	}
	
}
