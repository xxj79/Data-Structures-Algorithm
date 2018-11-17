package palindrom;

//Easy O(N^2), still using the extend approach
public class PalindromePartitioningII {
    public int minCut(String s){
	int n = s.length();
	int[] dp = new int[n];
	for(int i = 0; i<n;i++) dp[i] = i;
	char[] ch = s.toCharArray();
	for(int i = 1;i<n;i++){
	    helper(i, i, dp, ch);
	    helper(i-1, i, dp,ch);
	}
	return dp[n-1];
    }
    
    void helper(int i, int j, int[] dp, char[] ch){
	while(i>=0 && j<ch.length){
	    if(ch[i] != ch[j]) break;
	    dp[j] = Math.min(dp[j], i>0 ? dp[i-1] + 1 : 0);
	    i--;
	    j++;
	}
    }
}
