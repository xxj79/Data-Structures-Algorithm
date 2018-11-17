package stack;


//���˳��ŵģ��ȴ��ŵ�ǰ�ķ��ţ���������һ�����ŵ�ʱ���ٰ�ǰ��������ż��㣨�õ���ǰ���ֺ�ջ�����֣����ҽ����ջ
public class BasicCalculatorII {
    public int calculate(String s){
	Stack<Integer> stack = new Stack<>();
	char sign = '+';
	int num = 0;
	for(int i = 0;i<s.length();i++){
	    if(Character.isDigit(s.charAt(i))){
		num = 10*num+s.charAt(i) - '0';
	    }
	    //�����˳����������㲢����ջ�������Ӽ��Ȱ��������ջcache���Ӽ���������������㡣
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
