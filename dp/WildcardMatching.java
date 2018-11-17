package dp;

/*
Take away of these "matching" dp problem
1) Cover all the base cases, which means for those chars who can represent empty, we need to cover all those true base cases.
2) The key for recursive equatios is to consider each case that wild matching character could match
e.g. 

for '*' here: we just to consider it represents 
1) match any sequences 
2) empty sequences

Both will lead to a recursive equation, we just to combine all possibilities.

Same idea applies to problems like regular expression matching.
*/

public class WildcardMatching {
    public boolean isMatch(String s, String p){
	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	dp[0][0] = true;
	
	for(int i = 0;i<p.length();i++){
	    if(p.charAt(i)=='*' && dp[0][i])
		dp[0][i+1] = true;
	}
	
	for(int i= 0;i<s.length();i++){
	    for(int j = 0;j<p.length();j++){
		if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
		    dp[i+1][j+1] = dp[i][j];
		}
		
		else if(p.charAt(j) == '*'){
		  // '*' either treated 1) as any sequences 2) empty  
		    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
		}
	    }
	}
	return dp[s.length()][p.length()];
    }
}
