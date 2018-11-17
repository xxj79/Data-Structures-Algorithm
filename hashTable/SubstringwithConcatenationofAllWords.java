package hashTable;

import java.util.*;

/*
 * Key condition we have is that all words in the list
 * have the same length
 */
public class SubstringwithConcatenationofAllWords {
   public List<Integer> findSubstring(String s, String[] words){
       Map<String, Integer> counts = new HashMap<>();
       for(String word:words){
	   counts.put(word, counts.getOrDefault(word, 0)+1);
       }
       
       List<Integer> indexes = new ArrayList<>();
       if(s==null || words.length == 0) return indexes;
       
       int n = s.length(), num = words.length, len = words[0].length();
       for (int i = 0; i<n-num*len+1;i++){
	   Map<String, Integer> seen = new HashMap<>();
	   int j = 0;
	   while(j<num){
	       String word = s.substring(i+j*len, i+(j+1)*len);
	       if(counts.containsKey(word)){
		   seen.put(word, seen.getOrDefault(word, 0)+1);
		   if(seen.get(word)>counts.getOrDefault(word, 0)) break;
	       }
	       else break;
	       
	       j++;
	   }
	   if(j == num) indexes.add(i);
       }
       return indexes;
   }
}
