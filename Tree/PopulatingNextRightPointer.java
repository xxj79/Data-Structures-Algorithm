package Tree;

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x){val = x;}
}

class PopulatingNextRightPointer {
    public void connect(TreeLinkNode root){
	TreeLinkNode start = root;
	while(start!=null){
	    TreeLinkNode cur = start;
	    while(cur!=null){
		if(cur.left!=null) cur.left.next = cur.right;
		if(cur.right!=null && cur.next!=null) cur.right.next = cur.next.left;
		cur = cur.next;
	    }
	    start = start.left;
	}
    }
    
    //If it's not gauranteed complete binary tree?
    
    public void connectII(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}
