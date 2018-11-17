package Tree;

import java.util.*;

//关键是标记出null节点，然后直接preorder加队列操作即可deserialize
//Why preorder? Because its easier to reconstruct the tree, no need to identify "parent" node,
// since we follow a up-to-bottom manner.

public class SerializeDeserializeTree {
    private final String spliter = ",";
    private final String N = "x";
    
    public String serialize(TreeNode root){
	StringBuilder sb = new StringBuilder();
	buildString(root, sb);
	return sb.toString();
    }
    
    void buildString(TreeNode node, StringBuilder sb){
	if(node == null){
	    sb.append(N).append(spliter);
	}
	
	else{
	    sb.append(node.val).append(spliter);
	    buildString(node.left, sb);
	    buildString(node.right, sb);
	}
    }
    
    public TreeNode deserialize(String data){
	Queue<String> nodes = new LinkedList<>();
	nodes.addAll(Arrays.asList(data.split(spliter))); //注意这里的语法
	return buildTree(nodes);
    }
    
    TreeNode buildTree(Queue<String> nodes){
	String s = nodes.poll();
	if(s.equals(N)) return null;
	else{
	    TreeNode node = new TreeNode(Integer.parseInt(s));
	    node.left = buildTree(nodes);
	    node.right = buildTree(nodes);
	    return node;
	}
    }
}
