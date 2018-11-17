package linkedList;

public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k){
	ListNode[] parts = new ListNode[k];
	int len = 0;
	for(ListNode node = root;node!=null;node=node.next) len++;
	
	int n = len/k, r = len%k;
	ListNode node =root, pre = null;
	for(int i=0;i<k;i++, r--){
	    parts[i] = node;
	    for(int j = 0;j<n+(r>0?1:0);j++){
		pre = node;
		node = node.next;
	    }
	    if(pre != null) pre.next = null;
	}
	return parts;
    }
}
