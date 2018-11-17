package stack;

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens){
	Deque<Integer> stack = new ArrayDeque<Integer>();
	for(int i = 0;i<tokens.length;i++){
	    String s = tokens[i];
	    if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) stack.push(Integer.valueOf(s));
	    else{
		int n2 = stack.pop();
		int n1 = stack.pop();
		if(s == "+") stack.push(n1+n2);
		else if(s == "-") stack.push(n1 - n2);
		else if(s == "*") stack.push(n1*n2);
		else if(s == "/") stack.push(n1/n2);
	    }
	}
	return stack.pop();
    }
}
