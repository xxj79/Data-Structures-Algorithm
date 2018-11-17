package monotonous;

import java.util.*;

//Keep a mono-stack, where heights is always increasing, once encountered a smaller
// We calculate the largest it can make by exploring backwards.

//因为对一个递增栈，栈顶比当前高的长方形没有可能继续向右延伸，我们可以将他们分别出栈并计算他们能达到的最大长方形并更新ret，
//而对那些高度小于等于当前栈的，他们仍然有可能向右延伸，我们保留他们，
//最后， 对栈内剩下的全部计算一遍，我们需要用h=0，这样所有高度都大于0，将会全部出栈。

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
