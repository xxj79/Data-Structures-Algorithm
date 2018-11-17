package Tree;

import java.util.*;

public class SymmetricTree {
    //Iterative solution using Queue.
    public boolean isSymetric(TreeNode root){
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	if(root == null) return true;
	q.add(root.left);
	q.add(root.right);
	
	while(q.size()>1){
	    TreeNode left = q.poll();
	    TreeNode right = q.poll();
	    
	    if(left == null && right == null) continue;
	    if(left == null ^ right == null) return false;
	    if(left.val != right.val) return false;
	    
	    q.add(left.left);
	    q.add(right.right);
	    q.add(left.right);
	    q.add(right.left);
	}
	return true;
    }
      
    //从上往下的递归。注意我们总是成对的判断
    public boolean isSymmetricRecursive(TreeNode root){
	if(root == null) return true;
	return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode l, TreeNode r){
	if(l==null && r==null) return true;
	if(l==null || r==null) return false;
	
	return (l.val == r.val) && dfs(l.left, r.right) && dfs(l.right, r.left);
    }
}
