package linkedList;

/*
 * LeetCode 61. Given a list, rotate the list to the right by k places, 
 * where k is non-negative. And k could be a very large number
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n){
	if(head==null||head.next==null) return head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode fast = dummy, slow = dummy;
	
	int i=0;
	for(;fast.next!=null;i++){
	    fast = fast.next;
	}
	
	for(int j=i-n%i;j>0;j--){
	    slow = slow.next;
	}
	
	fast.next = dummy.next;
	dummy.next = slow.next;
	slow.next = null;
	
	return dummy.next;
    }
}
