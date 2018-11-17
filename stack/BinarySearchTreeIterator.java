package stack;

import java.util.*;

public class BinarySearchTreeIterator {
    Deque<TreeNode> stack;
    
    public BinarySearchTreeIterator(TreeNode root){
	stack = new ArrayDeque<>();
	
	while(root!=null){
	    stack.push(root);
	    root = root.left;
	}
    }
    
    public boolean hasNext(){
	return !stack.isEmpty();
    }
    
    public int next(){
	TreeNode cur = stack.pop();
	
	TreeNode temp = cur.right;
	while(temp!=null){
	    stack.push(temp);
	    temp = temp.left;
	}
	return cur.val;
    }
}
