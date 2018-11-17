package memo;

import java.util.*;

public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int N){
	if(!map.containsKey(N)){
	    List<TreeNode> ret = new ArrayList<>();
	    
	    if(N%2 == 0) return ret;
	    else if(N == 1) ret.add(new TreeNode(0));
	    else{
		for(int i = 1;i<=N-2;i++){
		    List<TreeNode> left = allPossibleFBT(i);
		    List<TreeNode> right = allPossibleFBT(N-1-i);
		    for(TreeNode l : left){
			for(TreeNode r : right){
			    TreeNode node = new TreeNode(0);
			    node.left = l;
			    node.right = r;
			    ret.add(node);
			}
		    }
		}
	    }
	    map.put(N, ret);
	}
	return map.get(N);
    }
}
