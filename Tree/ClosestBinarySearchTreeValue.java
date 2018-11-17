package Tree;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double min = Math.abs(root.val - target); //keep a record of minimum difference
        int res = root.val;
        while(root!=null){
            if(Math.abs(root.val-target)<min){
                res = root.val;
                min = Math.abs(res-target);
            }
            if(root.val>target)root = root.left;
            else root = root.right;
        }
        return res;
    }
}
