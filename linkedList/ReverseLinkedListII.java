package linkedList;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m , int n){
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode pre = dummy;
	//Locate the node before the reversing sublist
	for(int i=0;i<m-1;i++) pre = pre.next;
	
	//Fix pre and start, move next
	ListNode start = pre.next;
	ListNode next = start.next;
	
	for(int i=0;i<n-m;i++){
	    start.next = next.next;
	    next.next = pre.next;
	    pre.next = next;
	    next = start.next;
	}
	return dummy.next;
    }
}
