package BFS;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board){
	Set<String> visited = new HashSet<>();
	String target = "123450";
	
	String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s","");
	Queue<String> q = new LinkedList<>(Arrays.asList(s));
	
	visited.add(s);
	int ans = 0;
	
	while(!q.isEmpty()){
	    for(int sz=q.size();sz>0;sz--){
		String str = q.poll();
		if(str.equals(target)) return ans;
		int i = str.indexOf('0');
		int[] d = {1, -1, 3, -1};
		for(int k=0;k<4;++k){
		    int j = i+d[k];
		    if(j<0 || j>5 || i==2 && j==3 || i==3 && j==2) continue;
		    char[] ch =str.toCharArray();
		    char temp = ch[i];
		    ch[i]= ch[j];
		    ch[j] = temp;
		    s = String.valueOf(ch);
		    if(visited.add(s)) q.offer(s);
		}
	    }
	    ans++;
	}
	return -1;
    }
}
