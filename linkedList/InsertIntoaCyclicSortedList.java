package linkedList;

public class InsertIntoaCyclicSortedList {
    class Node{
	int val;
	Node next;
	 public Node(int val, Node next){
	     this.val = val;
	     this.next = next;
	 }
    }
    
    public Node insert(Node head, int v){
	if(head == null){
	    Node node = new Node(v, null);
	    node.next = node;
	    return node;
	}
	
	Node cur = head, add = new Node(v, null);
	while(true){
	    if((cur.val < cur.next.val && cur.val<= v && cur.next.val>= v) || 
		    (cur.val > cur.next.val && (v<=cur.next.val || v >= cur.val)) || 
		    (cur.next == head)){ //Pay attention to the last condition!! Only when we complete a  
		//cycle and find it still equal, we fit it in
                add.next = cur.next;
                cur.next = add;
                break;
            }
            cur = cur.next;
	}
	return head;
    }
}
