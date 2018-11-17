package Tree;

public class BalancedBinaryTree {
    //A O(N^2) solution is trivial
    public boolean isBalanced(TreeNode root){
	if(root == null) return true;
	if(Math.abs(height(root.left)-height(root.right))>1) return false;
	return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode n){
	if(n==null) return 0;
	return Math.max(height(n.left), height(n.right))+1;
    }
    
    //Better way is bottom up O(N)
    public boolean isBalanced1(TreeNode root){
	return dfs(root)!=-1;
    }
    
    private int dfs(TreeNode root){
	if(root == null) return 0;
	
	int left = dfs(root.left);
	int right = dfs(root.right);
	
	if(left == -1 || right == -1 || Math.abs(left - right)>1) return -1;
	
	return Math.max(left, right)+1;
    }
}
