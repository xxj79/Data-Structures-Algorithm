package twoPointers;

import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k){
	int[] map = new int[128];
	int start = 0, end = 0, counter = 0, len = 0;
	while(end < s.length()){
	    if(map[s.charAt(end++)]++ == 0) counter++;
	    while(counter>k)
		if(map[s.charAt(start++)]-- == 1) counter--;
	    len = end - start > len ? end - start : len;
	}
	return len;
    }
    
    /*
     * Follow up, if the input string is in the form of stream, which 
     * means we don't have access to the previous chars, how to solve 
     * this problem?
     */
    
    
    //LinkedHashMap<>:  key -- char, value -- index of its last appearance
    public int lengthOfLongestSubstringKDistinct1(String s, int k){
	int lo = 0, hi = 0;
	int n = s.length();
	int max = 0;
	if(k==0) return 0;
	LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
	
	while(hi<n){
	    char ch = s.charAt(hi);
	    if(map.containsKey(ch) || map.size() < k){
		map.remove(ch);
		map.put(ch, hi);
		max = Math.max(max,  hi++ - lo + 1);
	    }
	    else{
		Character key = map.keySet().iterator().next();
		lo = map.get(key);
		map.remove(key);
		lo++;
	    }
	}
	return max;
    }
}
