package stack;

//遇到开括号，先入数字，再入符号，然后将数字更新为0， 符号更新为1，
//遇到闭括号，当前数字结合栈顶符号，再加上出栈的之前结果。
public class BasicCalculator {
    public int calculate(String s){
	int len = s.length(), sign = 1, ret = 0;
	Stack<Integer> stack = new Stack<>();
	for(int i = 0;i<len;i++){
	    if(Character.isDigit(s.charAt(i))){
		int num = s.charAt(i) - '0', j = i+1;
		while(j<len && Character.isDigit(s.charAt(j))){
		    num = num*10 + s.charAt(j++) - '0';
		}
		i = j-1;
		ret += num*sign;
	    }else if(s.charAt(i) == '+')
		sign = 1;
	    else if(s.charAt(i) == '-')
		sign = -1;
	    else if(s.charAt(i) == '('){
		stack.push(ret);
		stack.push(sign);
		ret = 0;
		sign = 1;
	    }else if(s.charAt(i) == ')'){
		ret = ret * stack.pop() + stack.pop();
	    }
	}
	return ret;
    }
}
