package Tree;

import java.util.*;

//�ؼ��Ǳ�ǳ�null�ڵ㣬Ȼ��ֱ��preorder�Ӷ��в�������deserialize
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
	nodes.addAll(Arrays.asList(data.split(spliter))); //ע��������﷨
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
