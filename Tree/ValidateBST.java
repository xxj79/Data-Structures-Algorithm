package Tree;

import java.util.*;

public class ValidateBST {
    
    //Solution 1: Recursion
    public boolean isValidBSTRecursion(TreeNode root){
	return dfs(root, null, null);
    }
    
    private boolean dfs(TreeNode node, Integer l, Integer r){
	if(node == null) return true;
	if(l!=null && node.val<=l || r!=null && node.val>=r) return false;
	return dfs(node.left, l, node.val) && dfs(node.right, node.val, r);
    }
    
    //Solution 2: Inorder traversal with stack
    public boolean isValidBSTInorder(TreeNode root){
	if(root == null) return true;
	Deque<TreeNode> stack = new ArrayDeque<>();
	Integer pre = null;
	while(root!=null || !stack.isEmpty()){
	    while(root!=null){
		stack.push(root);
		root = root.left;
	    }
	    root = stack.pop();
	    if(pre!=null && root.val<=pre) return false;
	    pre = root.val;
	    root = root.right;
	}
	return true;
    }
    
    Integer last = null;
    //Solution 3: Inorder traversal using recursion
    public boolean isValidBSTInorderRecursion(TreeNode root){
	if(root == null) return true;
	
	if(!isValidBSTInorderRecursion(root.left)) return false;
	
	if(last!=null && root.val <= last) return false;
	last = root.val;
	
	return isValidBSTInorderRecursion(root.right);
    }
}
