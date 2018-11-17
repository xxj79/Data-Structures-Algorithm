package monotonous;

import java.util.*;

//һ�����У�ÿ��ɾ������a[i] if ( a[i] > a[i-1]) ��������ж��ٴβ������û�п���ɾ����Ԫ��

//��������ɨ�裬ά��һ���������ϲ����ĵ���ջ
public class TimesToDeleteElements {
    public int solution(int[] a){
	int ret = 0;
	Deque<Integer> stack = new ArrayDeque<>();
	for(int i= a.length-1; i>-1;i--){
	    int cur = 0;
	    while(!stack.isEmpty() && a[i] < stack.peek()){
		cur++;
		stack.pop();
	    }
	    ret = Math.max(cur, ret);
	    stack.push(a[i]);
	}
	return ret;
    }
}
