package monotonous;

import java.util.*;

//一个数列，每次删除所有a[i] if ( a[i] > a[i-1]) 问最后会进行多少次操作后会没有可以删除的元素

//从右往左扫描，维护一个从下往上不减的单调栈
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
