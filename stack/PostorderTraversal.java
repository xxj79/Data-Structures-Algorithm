package stack;

import java.util.*;

public class PostorderTraversal {
    
    //Just do node -> right -> left (modify preorder traversal), then reverse the list.
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !st.isEmpty()){
            if(cur == null) cur = st.pop();
            ret.addFirst(cur.val);
            if(cur.left!=null) st.push(cur.left);
            cur = cur.right;
        }
        return ret;
    }
}
