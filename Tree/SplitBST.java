package Tree;

public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V){
	if(root == null) return new TreeNode[2];
	
	TreeNode[] ret = new TreeNode[2];
	
	if(root.val<=V){
	    TreeNode[] right = splitBST(root.right, V);
	    root.right = right[0];
	    ret[0] = root;
	    ret[1] = right[1];
	    return ret;
	}
	else{
	    TreeNode[] left = splitBST(root.left, V);
	    root.left = left[1];
	    ret[1] = root;
	    ret[0] = left[0];
	    return ret;
	}
    }
}
