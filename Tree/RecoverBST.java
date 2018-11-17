package Tree;

import java.util.*;

/*
Always remember that:

Inorder traversal is POWERFUL!!
*/
public class RecoverBST {
    public void recoverTree(TreeNode root){
	TreeNode first = null;
	TreeNode second = null;
	TreeNode cur = root;
	TreeNode prev = null;
	
	Deque<TreeNode> stack = new ArrayDeque<>();
	
	while(cur!=null || !stack.isEmpty()){
	    while(cur!=null){
		stack.push(cur);
		cur = cur.left;
	    }
	    cur = stack.pop();
	    if(prev!=null&&cur.val<=prev.val){
		if(first == null) first = prev;
		second = cur;
	    }
	    prev = cur;
	    cur = cur.right;
	}
	int temp = first.val;
	first.val = second.val;
	second.val = temp;
    }
    
    //Recursion version
    public void recoverTreeRecursion(TreeNode root) {
        //use inorder traversal to detect incorrect node

        inOrder(root);


        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void inOrder(TreeNode root){
        if(root == null) return;
        //search left tree
        inOrder(root.left);

        //in inorder traversal of BST, prev should always have smaller value than current value
        if(prev != null && prev.val >= root.val){
            //incorrect smaller node is always found as prev node
            if(first == null) first = prev;
          //incorrect larger node is always found as curr(root) node
            second = root;
        }


        //update prev node
        prev = root;

        //search right tree
        inOrder(root.right);
    }
}
