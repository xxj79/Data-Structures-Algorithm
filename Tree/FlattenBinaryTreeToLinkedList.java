package Tree;

public class FlattenBinaryTreeToLinkedList {
    //Post order traversal
    public void flatten(TreeNode root){
	if(root == null) return;
	
	TreeNode left = root.left;
	TreeNode right = root.right;
	
	flatten(left);
	flatten(right);
	
	root.left = null;
	root.right = left;
	
	TreeNode cur = root;
	while(cur.right!=null) cur = cur.right;
	cur.right = right;
    }
}
