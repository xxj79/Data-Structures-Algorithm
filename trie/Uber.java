package trie;

import java.util.*;

public class Uber {
    static class Node{
	int val;
	List<Node> child;
	boolean isLeaf;
	public Node(int val){
	    this.val = val;
	    child = new ArrayList<>();
	}
    }
    
    List<Integer> set;
    public List<Node> find(Node root, List<Integer> list, int d){
	set = list;
	return dfs(root, d, 0);
    }
    
    List<Node> dfs(Node node, int d, int depth){
	List<Node> ret = new ArrayList<>();
	if(set.contains(node.val)) return ret;
	if(depth == d) {
	    ret.add(node);
	    return ret;
	}
	for(Node c : node.child)
	    ret.addAll(dfs(c, d, depth+1));
	return ret;
    }
    
    public static void main(String[] args){
	Node root = new Node(1);
	root.child.add(new Node(4));
	root.child.add(new Node(8));
	Node four = root.child.get(0);
	Node eight = root.child.get(1);
	four.child.add(new Node(3));
	four.child.add(new Node(5));
	four.child.add(new Node(6));
	
	eight.child.add(new Node(7));
	eight.child.add(new Node(8));
	eight.child.add(new Node(10));
	
	List<Integer> list = new ArrayList<>();
	list.add(3);
	list.add(8);
	
	Uber obj = new Uber();
	List<Node> ret = obj.find(root, list, 2);
	for(Node node : ret)
	    System.out.println(node.val);
    }
}
