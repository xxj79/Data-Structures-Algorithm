package stack;


//带乘除号的，先存着当前的符号，当遇到下一个符号的时候，再把前面这个符号计算（用到当前数字和栈顶数字）并且结果入栈
public class BasicCalculatorII {
    public int calculate(String s){
	Stack<Integer> stack = new Stack<>();
	char sign = '+';
	int num = 0;
	for(int i = 0;i<s.length();i++){
	    if(Character.isDigit(s.charAt(i))){
		num = 10*num+s.charAt(i) - '0';
	    }
	    //遇到乘除，立即计算并更新栈；遇到加减先把这个数入栈cache，加减运算留到最后再算。
	    if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() -1){
		if(sign == '+') stack.push(num); 
		if(sign == '-') stack.push(-num);
		if(sign == '*') stack.push(num*stack.pop());
		if(sign == '/') stack.push(stack.pop()/num);
		num = 0;
		sign = s.charAt(i);
	    }
	}
	int ret = 0;
	while(!stack.isEmpty())ret+= stack.pop();
	return ret;
    }
}
