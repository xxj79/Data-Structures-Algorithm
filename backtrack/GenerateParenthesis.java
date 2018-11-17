package backtrack;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
	List<String> ret = new ArrayList<>();
	dfs(new StringBuilder(), 0, n, n, ret);
	return ret;
    }
    
    void dfs(StringBuilder s, int count, int l, int r, List<String> ret){
	if(count<0) return;
	if(l == 0 && r == 0){
	    ret.add(s.toString());
	    return;
	}
	if(l>0){
	    s.append("(");
	    dfs(s, count+1, l-1, r, ret);
	    s.deleteCharAt(s.length()-1);
	}
	if(r>0){
	    s.append(")");
	    dfs(s, count-1, l, r-1, ret);
	    s.deleteCharAt(s.length()-1);
	}
    }
}
