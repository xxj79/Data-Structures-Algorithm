package stack;

import java.util.*;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !st.isEmpty()){
            while(cur!=null){
        	st.push(cur); //Cach it, we need first explore the left most node.
        	cur = cur.left;
            }
            cur = st.pop();
            ret.add(cur.val);
            cur = cur.right; //we've add node's left subtree and itself, time
            	//to go to its right subtree
        }
        return ret;
    }
}
