package stack;

import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s){
	int ret = 0;
	Deque<Integer> st = new ArrayDeque<>();
	st.push(-1);
	for(int i = 0;i<s.length();i++){
	    if(s.charAt(i) == '('){
		st.push(i);
	    }
	    else{
		st.pop();
		if(st.isEmpty()){
		    st.push(i);
		}
		else{
		    ret = Math.max(ret, i-st.peek());
		}
	    }
	}
	return ret;
    }
}
