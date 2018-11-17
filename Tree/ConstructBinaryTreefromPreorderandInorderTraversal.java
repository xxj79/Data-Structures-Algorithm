package Tree;

import java.util.*;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder){
	Map<Integer, Integer> map = new HashMap<>();
	
	for(int i=0;i<inorder.length;i++) map.put(inorder[i], i);
	
	return dfs(0, 0, inorder.length-1, preorder, inorder, map); 
    }
    
    TreeNode dfs(int lpre, int lin, int rin, int[] preorder, int[] inorder, Map<Integer, Integer> map){
	if(lpre >= preorder.length || lin > rin) return null;
	
	TreeNode ret = new TreeNode(preorder[lpre]);
        
        int index = map.get(preorder[lpre]);
        
        ret.left = dfs(lpre+1, lin, index-1, preorder, inorder, map);
        ret.right = dfs(lpre +index-lin+1, index + 1, rin, preorder, inorder, map);
        
        return ret;
    }
    
    
    //Similar problem, construct BST from inorder and postorder
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        return dfs2(0, inorder.length-1, postorder.length - 1, inorder, postorder, map);
    }
    
    TreeNode dfs2(int inL, int inR, int poR, int[] inorder, int[] postorder, Map<Integer, Integer> map){
        if(inL>inR || poR < 0) return null;
        TreeNode root = new TreeNode(postorder[poR]);
        int ind = map.get(root.val);
        root.right = dfs2(ind+1, inR, poR-1, inorder, postorder, map); //doesn't matter we do right first or left first
        root.left = dfs2(inL, ind -1, poR - (inR-ind) -1, inorder, postorder, map);
        return root;
    }
    
    //construct BST from preorder and postorder
    int[] pre;
    int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        Map<Integer, Integer> map = new HashMap<>();
	    for(int i=0;i<post.length;i++) map.put(post[i], i);
        
        return make(0, pre.length-1, 0, map);
    }
    
    public TreeNode make(int l1, int r1, int l2, Map<Integer, Integer> map) {
        if (l1 > r1) return null;
        TreeNode root = new TreeNode(pre[l1]);
        if (l1 == r1) return root;
        
        int ind = map.get(pre[l1+1]);
        
        root.left = make(l1+1, l1+1+ind-l2, l2, map);
        root.right = make(l1+2+ind-l2, r1, ind + 1, map);
        return root;
    }
    
}
