package stack;
 
import java.util.*;


/*
To convert prefix polish notation to post, we scan the prefix from end to start,
if number just push into stack. If operator, sb = pop+pop+cur and push sb into
stack. 
*/
public class PrefixToPostfix {
    public String preToPost(String s){
	char[] a = s.toCharArray();
	Deque<String> stack = new ArrayDeque<>();
	for(int i=a.length-1;i>=0;i--){
	    if(Character.isDigit(a[i])) stack.push(String.valueOf(a[i]));
	    else{
		StringBuilder sb = new StringBuilder();
		sb.append(stack.pop()).append(stack.pop()).append(a[i]);
		stack.push(sb.toString());
	    }
	}
	return stack.pop();
    }
    
    public static void main(String[] args){
	PrefixToPostfix obj = new PrefixToPostfix();
	System.out.println(obj.preToPost("*-567"));
    }
}
