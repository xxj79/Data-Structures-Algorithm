package sort;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists){
	return partition(lists, 0, lists.length);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end){
	if(start == end) return lists[start];
	
	if(start < end) {
	    int mid = start + (end - start)/2;
	    
	    ListNode l1 = partition(lists, start, mid);
	    ListNode l2 = partition(lists, mid+1, end);
	    
	    return mergeTwoLists(l1, l2);
	}
	return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
	if(l2 == null) return l1;
	if(l1 == null) return l2;
	
	if(l1.val < l2.val){
	    l1.next = mergeTwoLists(l1.next, l2);
	    return l1;
	}
	else{
	    l2.next = mergeTwoLists(l1, l2.next);
	    return l2;
	}
    }
}
