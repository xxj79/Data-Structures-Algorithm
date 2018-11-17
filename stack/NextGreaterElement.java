package stack;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
    
    //If we have a cycle array?
    public int[] nextGreaterElementesII(int[] nums){
	Deque<Integer> stack = new ArrayDeque<>();
	int[] ret = new int[nums.length];
	Arrays.fill(ret, -1);
	
	for(int i = 0;i<2*nums.length;i++){
	    int ind = i % nums.length;
	    while(!stack.isEmpty() && nums[stack.peek()]<nums[ind])
		ret[stack.pop()] = nums[ind];
	    
	    if(i<nums.length) stack.push(i);
	}
	return ret;
    }
}
