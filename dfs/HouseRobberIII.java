package dfs;

import java.util.*;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return Math.max(ret[0], ret[1]);
    }
    
    int[] dfs(TreeNode node){
        int[] ret = new int[2]; // 0 - not pick, 1-pick
        if(node == null) return ret;
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = node.val + left[0] + right[0];
        
        return ret;
    }
    
    //Normal DFS + Memo
    public int rob1(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }
}
