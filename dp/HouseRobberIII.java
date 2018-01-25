package dp;

import java.util.*;

public class HouseRobberIII {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	//Solution 1: Normal memoization
	public int rob(TreeNode root){
		return dfs(root, new HashMap<>());
	}
	
	private int dfs(TreeNode node, Map<TreeNode, Integer> map){
		if(node == null) return 0;
		if(map.containsKey(node)) return map.get(node);
		
		int val = 0;
		
		if(node.left!=null)
			val+=dfs(node.left.left, map)+dfs(node.left.right, map);
		
		if(node.right!=null)
			val+=dfs(node.right.left, map)+dfs(node.right.right, map);
		
		val = Math.max(val+node.val, dfs(node.left, map) + dfs(node.right, map));
		map.put(node, val);
		
		return val;
	}
	
	//Solution 2 (Better): Consider each house with two states: robbed or not robbed
	//Take away with this approach: break down the different/binary states elements have, and find the 
	//recurrence relation between those states!!! (similar to stock problem, which has 0 and 1 states)
	public int rob1(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
}
