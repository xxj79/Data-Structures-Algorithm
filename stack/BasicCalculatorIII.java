package stack;

import java.util.*;

public class BasicCalculatorIII {
    public int calculate(String s){
	s.replaceAll("\\s+", "");
	Deque<Integer> stack = new ArrayDeque<>();
	char sign = '+';
	for(int i=0;i<s.length();){
	    char c = s.charAt(i);
	    
	    //����ǿ����ţ�recursion����������Ľ�������֮ǰ������ջ
	    if(c=='('){
		int count = 1;
		int j = i+1;
		while(j<s.length() && count>0){
		    if(s.charAt(j) == '(') count++;
		    else if(s.charAt(j) == ')') count--;
		    j++;
		}
		int blockValue = calculate(s.substring(i+1, j-1));
		i = j;
		if(sign == '+')
		    stack.push(blockValue);
		else if(sign == '-')
		    stack.push(-blockValue);
		else if(sign == '*')
		    stack.push(stack.pop() * blockValue);
		else if(sign == '/')
		    stack.push(stack.pop() / blockValue);
	    }
	    //��������֣�get��������Ȼ����֮ǰ������ջ
	    else if(Character.isDigit(c)){
		int j = i;
		int value = 0;
		while(j<s.length() && Character.isDigit(s.charAt(j))) {
		    value = 10*value + (s.charAt(j) - '0');
		    j++;
		}
		i = j;
		if(sign == '+')
		    stack.push(value);
		else if(sign == '-')
		    stack.push(-value);
		else if(sign == '*')
		    stack.push(stack.pop() * value);
		else if(sign == '/')
		    stack.push(stack.pop() / value);
	    }
	    //���ţ�ֱ�Ӹ���
	    else{
		sign = c;
		i++;
	    }
	}
	int ret = 0;
	while(!stack.isEmpty()){
	    ret += stack.pop();
	}
	return ret;
    }
}
