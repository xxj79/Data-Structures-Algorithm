package twoPointers;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
	int l = 0, r = 0, ret = 0;
	char[] a = s.toCharArray();
	int[] count = new int[128];
	while(r<a.length){
	    count[a[r]]++;
	    while(count[a[r]]>1)
		count[a[l++]]--;
	    ret = Math.max(ret, r++ -l+1);
	}
	return ret;
    }
}
