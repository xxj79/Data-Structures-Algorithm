package monotonous;

import java.util.*;

//Keep a mono-stack, where heights is always increasing, once encountered a smaller
// We calculate the largest it can make by exploring backwards.

//��Ϊ��һ������ջ��ջ���ȵ�ǰ�ߵĳ�����û�п��ܼ����������죬���ǿ��Խ����Ƿֱ��ջ�����������ܴﵽ����󳤷��β�����ret��
//������Щ�߶�С�ڵ��ڵ�ǰջ�ģ�������Ȼ�п����������죬���Ǳ������ǣ�
//��� ��ջ��ʣ�µ�ȫ������һ�飬������Ҫ��h=0���������и߶ȶ�����0������ȫ����ջ��

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights){
	int len = heights.length;
	int ret = 0;
	Stack<Integer> stack = new Stack<>();
	for(int i = 0; i<=len;i++){
	    int h = i == len ? 0 : heights[i];
	    while(!stack.isEmpty() && h < heights[stack.peek()]){
		int ind = stack.pop();
		ret = Math.max(ret, heights[ind] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	    }
	    stack.push(i);
	}
	return ret;
    }
    
    
    //Follow: Maximal Rectangle, we can use exact the same solution to solve it
    //With additional tricks; Do this M times, while M is the # of rows.
    
    public int maximalRectangle(char[][] matrix){
	if(matrix.length == 0) return 0;
	int n = matrix[0].length;
	int[] heights = new int[n];
	int ret = 0;
	for(char[] row : matrix){
	    for(int i = 0;i<n;i++){
		if(row[i] == '1')
		    heights[i]++;
		else
		    heights[i] = 0;
	    }
	    
	    ret = Math.max(ret, largestRectangleArea(heights));
	}
	return ret;
    }
}
