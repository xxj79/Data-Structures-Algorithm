package linkedList;

public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
	ListNode run = head;
	int num = k;
	if(num<2 || run == null) return head;
	//Find the last node in k group
	while(--num>0){
	    run = run.next;
	    if(run == null) return head;
	}
	//prepare for reversing
	ListNode next = run.next;
	run.next = null;
	ListNode node = head, pre = reverseKGroup(next, k);
	//reverse
	while(node!=null){
	    ListNode nextNode = node.next;
	    node.next = pre;
	    pre = node;
	    node = nextNode;
	}
	
	return run;
    }
}
