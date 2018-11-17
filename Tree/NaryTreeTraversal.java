package Tree;

import java.util.*;

public class NaryTreeTraversal {
    class Node{
	public int val;
	public List<Node> children;
	public Node(){}
	public Node(int _val, List<Node> _children){
	    val = _val;
	    children = _children;
	}
    }
    
    public List<Integer> preorder(Node root){
	List<Integer> ret = new ArrayList<>();
	if(root == null) return ret;
	Deque<Node> st = new ArrayDeque<>();
	st.push(root);
	
	while(!st.isEmpty()){
	    Node cur = st.pop();
	    ret.add(cur.val);
	    List<Node> next = cur.children;
	    for(int i = next.size()-1;i>=0;i--){
		st.push(next.get(i));
	    }
	}
	return ret;
    }
    
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.addFirst(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        return list;
    }
}
