package prob;
import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
	val = x;
    }
}

public class RandomListNode {
    ListNode head;
    Random random;
    
    public RandomListNode(ListNode h){
	head = h;
	random = new Random();
    }
    
    public int getRandom(){
	ListNode cur = head;
	int r = cur.val;
	for(int i = 1; cur.next != null; i++){
	    cur = cur.next;
	    if(random.nextInt(i+1) < 1) r = cur.val; // 1 就是size k， 这里是1
	}
	
	return r;
    }
}
