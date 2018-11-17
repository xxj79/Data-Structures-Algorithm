package Tree;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root){
	return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int sum){
	if(node == null) return 0;
	if(node.left == null && node.right == null) return sum*10 + node.val;
	return dfs(node.left, sum*10 + node.val) + dfs(node.right, sum*10 + node.val);
    }
}
