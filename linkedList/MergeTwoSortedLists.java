package linkedList;

/*
 * Tail recursion: the last call is the method itself.
 */

public class MergeTwoSortedLists {
    
    //recursion (not a tail recursion tho, run risk of stack overflow)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
	if(l1 == null) return l2;
	if(l2 == null) return l1;
	if(l1.val < l2.val){
	    l1.next = mergeTwoLists(l1.next, l2);
	    return l1;
	}
	
	else{
	    l2.next = mergeTwoLists(l1, l2.next);
	    return l2;
	}
    }
    
    
    //Just straightforward iteration solution
    public ListNode mergeTwoListsNaive(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), node = dummy;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
            node.next = null;
        }
        if(l1!=null) node.next = l1;
        if(l2!=null) node.next = l2;
        return dummy.next;
    }
}
