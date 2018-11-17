package Tree;


/*
 * DFS postordr traversal
 */

public class UniValueSubtrees {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
    
    boolean dfs(TreeNode node){
        if(node == null) return true;
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        
        if(left && right){
            if(node.left!=null && node.left.val != node.val){
                return false;
            }
            if(node.right!=null && node.right.val != node.val){
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
