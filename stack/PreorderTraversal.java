package stack;

import java.util.*;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode node){
	List<Integer> ret = new ArrayList<>();
	Deque<TreeNode> st = new ArrayDeque<>();
	while(node!=null || !st.isEmpty()){
	    if(node == null) node = st.pop();
	    ret.add(node.val);
	    
	    //We've add this node, we need first explore its left subtree
	    //so we cache its right child.
	    if(node.right!=null) st.push(node.right);
	    node = node.left;
	}
	return ret;
    }
}
