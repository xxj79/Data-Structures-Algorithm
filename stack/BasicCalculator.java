package stack;

//���������ţ��������֣�������ţ�Ȼ�����ָ���Ϊ0�� ���Ÿ���Ϊ1��
//���������ţ���ǰ���ֽ��ջ�����ţ��ټ��ϳ�ջ��֮ǰ�����
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
