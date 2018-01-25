package dp;

import java.util.*;

/*
 * DP idea, very similar to word break.
 * 
 * For s.substring(0, j), scan from (0,j) to (j-1, j),
 * if(0, i) is already true and (i, j) is found in the dictionary
 * (0, j) is true;
 * 
 * 
 * We could also use trie to help with our dp, see dp package for more.
 */
public class ConcatenatedWords {
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
		    for (int j = 0; j < i; j++) {
			if (!dp[j]) continue;
			if (dict.contains(word.substring(j, i))) {
			    dp[i] = true;
			    break;
			}
		    }
		}
		return dp[word.length()];
    }
}
