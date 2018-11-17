package linkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	int c = 0;
	ListNode ret = new ListNode(0);
	ListNode head = ret;
	
	while(l1!=null || l2!=null || c!=0){
	    int sum = (l1 == null ? 0 : l1.val) + 
		    (l2 == null ? 0 : l2.val) + c;
	    ret.next = new ListNode(sum%10);
	    c = sum/10;
	    ret = ret.next;
	    if(l1!=null) l1 = l1.next;
	    if(l2!=null) l2 = l2.next;
	}
	return head.next;
    }
}
