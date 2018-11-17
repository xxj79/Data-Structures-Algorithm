package backtrack;

import java.util.*;

/*
 * Regular backtracking O(3^N) solution
 * 
 * Just a little bit nasty
 */
public class ExpressionAddOperator {
    public List<String> addOperators(String num, int target){
	List<String> ret = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	dfs(ret, sb, num.toCharArray(), 0, target, 0, 0);
	return ret;
    }
    
    public void dfs(List<String> ret, StringBuilder sb, char[] num, int pos, int target, long pre, long multi){
	if(pos == num.length){
	    if(target == pre) ret.add(sb.toString());
	    return;
	}
	
	long cur = 0;
	for(int i = pos; i<num.length; i++){
	    if(num[pos] == '0' && i!=pos) break;
	    cur = 10 * cur + num[i] - '0';
	    int len = sb.length();
	    if(pos == 0){
		dfs(ret, sb.append(cur), num, i+1, target, cur, cur);
		sb.setLength(len);//注意这个将stringbuilder回溯的方法， 记住原始长度然后setLength()
	    }
	    else{
		dfs(ret, sb.append("+").append(cur), num, i+1, target, pre+cur, cur);
		sb.setLength(len);
		dfs(ret, sb.append("-").append(cur), num, i+1, target, pre - cur, -cur);
		sb.setLength(len);
		dfs(ret, sb.append("*").append(cur), num, i+1, target, pre - multi + multi*cur, multi*cur);
		sb.setLength(len);
	    }
	}
    }
}
