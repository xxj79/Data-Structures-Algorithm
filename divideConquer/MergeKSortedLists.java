package divideConquer;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

public class MergeKSortedLists {

    /*
     * Divide and conquer, O(nklgk)
     */
    public ListNode mergeKLists(ListNode[] lists){
	return partition(lists, 0, lists.length -1);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end){
	if(start == end){
	    return lists[start];
	}
	
	if(start < end){
	    int mid = start + (end-start)/2;
	    ListNode l1 = partition(lists, start, mid);
	    ListNode l2 = partition(lists, mid+1, end);
	    
	    return mergeTwoLists(l1, l2);
	}
	
	return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
	if(l2 == null) return l1;
	if(l1 == null) return l2;
	
	if(l1.val<l2.val){
	    l1.next = mergeTwoLists(l1.next, l2);
	    return l1;
	}
	else{
	    l2.next = mergeTwoLists(l1, l2.next);
	    return l2;
	}
    }
    
    /*
     * Priority Queue, O(nklgk)
     */
    
    public ListNode mergeKListsHeap(ListNode[] lists){
	if(lists==null || lists.length == 0) return null;
	
	PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
	    public int compare(ListNode o1, ListNode o2){
		return o1.val - o2.val;
	    }
	});
	
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;
	
	for(ListNode node : lists)
	    if(node!=null)
		q.add(node);
	
	while(!q.isEmpty()){
	    tail.next = q.poll();
	    tail = tail.next;
	    
	    if(tail.next!=null)
		q.add(tail.next);
	}
	
	return dummy.next;
    }
}
