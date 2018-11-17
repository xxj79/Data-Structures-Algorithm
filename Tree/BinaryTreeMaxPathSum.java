package Tree;

public class BinaryTreeMaxPathSum {
    int max;
    public int maxPathSum(TreeNode root){
	max = Integer.MIN_VALUE;
	dfs(root);
	return max;
    }
    
    private int dfs(TreeNode node){
	if(node == null) return 0;
	
	int left = Math.max(0, dfs(node.left));
	int right = Math.max(0, dfs(node.right));
	
	max = Math.max(max, node.val+left+right);
	return node.val+Math.max(left, right);
    }
}
