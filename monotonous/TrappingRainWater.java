package monotonous;

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height){
	int ret = 0, cur = 0;
	Stack<Integer> stack = new Stack<>();
	while(cur < height.length){
	    while(!stack.isEmpty() && height[cur] > height[stack.peek()]){
		int top = stack.pop();
		if(stack.isEmpty()) break;
		int d = cur - stack.peek() - 1;
		int h = Math.min(height[cur], height[stack.peek()]) - height[top];
		ret += d * h;
	    }
	    stack.push(cur);
	}
	return ret;
    }
}