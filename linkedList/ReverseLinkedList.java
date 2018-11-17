package linkedList;

public class ReverseLinkedList {
    public ListNode reverseListIterative(ListNode head){
	ListNode pre = null;
	while(head!=null){
	    ListNode next = head.next;
	    head.next = pre;
	    pre = head;
	    head = next;
	}
	return pre;
    }
    
    
    
    public ListNode reverseListTailRecursion(ListNode head){
	return reverseListUtil(head, null);
    }
    private ListNode reverseListUtil(ListNode head, ListNode pre){
	if(head == null) return pre;
	ListNode next = head.next;
	head.next = pre;
	return reverseListUtil(next, head);
    }
    
    
    
    //Non tail recursion, tricky
    public ListNode reverseListNonTailRecursion(ListNode head){
	if(head == null || head.next == null) return head;
	
	ListNode ret = reverseListNonTailRecursion(head.next);
	
	head.next.next = head;
	head.next = null;
	return ret;
    }
}
