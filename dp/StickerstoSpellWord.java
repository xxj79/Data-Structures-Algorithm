package dp;

import java.util.*;
/*
 * Just try every stickers we have (hopefully with some early termination)
 * The target will be the chars remained to be matched.
 * 
 * So (also the key part) we realize that the mapping relation for memo
 * could be String -> NumOfStickersNeeded
 * 
 * The logic is actually straightforward, notice how we pre-cache the chars
 * existed in each sticker word using a 2d array.
 */
public class StickerstoSpellWord {
    public int minStickers(String[] stickers,String target){
	int m = stickers.length;
	int[][] mp = new int[m][26];
	Map<String, Integer> dp = new HashMap<>();
	for(int i=0;i<m;i++){
	    for(char c : stickers[i].toCharArray()) mp[i][c-'a']++;
	}
	dp.put("",0);
	return dfs(dp, mp, target);
    }
    private int dfs(Map<String, Integer> dp, int[][] mp, String target){
	if(dp.containsKey(target)) return dp.get(target);
	int ans = Integer.MAX_VALUE, n = mp.length;
	int[] tar = new int[26];
	for(char c:target.toCharArray()) tar[c-'a']++;
	
	for(int i=0;i<n;i++){
	    if(mp[i][target.charAt(0)-'a'] == 0) continue;
	    StringBuilder sb = new StringBuilder();
	    for(int j=0;j<26;j++){
		if(tar[j]>0)
		    for(int k=0;k<Math.max(0, tar[j]-mp[i][j]);k++){
			sb.append((char)('a'+j));
		    }
	    }
	    String s = sb.toString();
	    int temp = dfs(dp, mp,s);
	    if(temp!=-1) ans= Math.min(ans, 1+temp);
	}
	dp.put(target, ans==Integer.MAX_VALUE ? -1 : ans);
	return dp.get(target);
    }
}
