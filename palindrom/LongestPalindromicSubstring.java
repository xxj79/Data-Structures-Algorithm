package palindrom;

public class LongestPalindromicSubstring {
    int lo;
    int max;
    
    public String longestPalindrome(String s){
	if(s==null||s.length()<2) return s;
	for(int i=0;i<s.length()-1;i++){
	    extend(s, i, i);
	    extend(s, i, i+1);
	}
	return s.substring(lo, lo+max);
    }
    
    void extend(String s, int i, int j){
	for(;i>=0 && j<s.length() && s.charAt(i) == s.charAt(j);i--, j++){}
	if(j-i-1>max){
	    lo = i+1;
	    max = j-1-i;
	}
    }
}
