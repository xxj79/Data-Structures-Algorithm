package Tree;

/*
The idea is actually similar to UniqueBST,

Divide and conqure!! 

Bottom up DFS
*/

import java.util.*;

public class UniqueBSTsII {
    public List<TreeNode> generateTrees(int n){
	if(n==0) return new LinkedList<TreeNode>();
	return dfs(1, n);
    }
    
    List<TreeNode> dfs(int s, int e){
	List<TreeNode> ret = new ArrayList<>();
	if(s>e) {
	    ret.add(null);
	    return ret;
	}
	
	for(int i=s;i<=e;i++){
	    List<TreeNode> left = dfs(s,i-1);
	    List<TreeNode> right=  dfs(i+1, e);
	    for(TreeNode nl:left){
		for(TreeNode nr:right){
		    TreeNode root = new TreeNode(i);
		    root.left = nl;
		    root.right = nr;
		    ret.add(root);
		}
	    }
	}
	return ret;
    }
}
