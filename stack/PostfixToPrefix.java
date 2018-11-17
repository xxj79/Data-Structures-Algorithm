package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
To convert postfix to prefix, just scan the input, if number push into
stack; if operator, n2 = stack.pop(), n1 = stack.pop().

 sb = operator + n1 + n2,  then push sb into stack.
*/


public class PostfixToPrefix {
    public String postToPre(String s){
	char[] a = s.toCharArray();
	Deque<String> stack = new ArrayDeque<>();
	for(int i=0;i<a.length;i++){
	    if(Character.isDigit(a[i])) stack.push(String.valueOf(a[i]));
	    else{
		StringBuilder sb = new StringBuilder();
		String s2 = stack.pop();
		String s1 = stack.pop();
		sb.append(a[i]).append(s1).append(s2);
		stack.push(sb.toString());
	    }
	}
	return stack.pop();
    }
    
    public static void main(String[] args){
	PostfixToPrefix obj = new PostfixToPrefix();
	System.out.println(obj.postToPre("56-7*"));
    }
}
