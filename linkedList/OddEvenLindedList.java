package linkedList;

public class OddEvenLindedList {
    //Concise and straightforward
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even; 

            while (even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead; 
        }
        return head;    
    }
    
    
    
    //my submission
    public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode second = head.next, temp = null, node = head, tail = null;
        
        int flag = 0;
        
        while(node!=null){
            if(flag++%2==0) tail = node;
            
            temp = node.next;
            if(temp!=null) 
                node.next = temp.next;
            node = temp;
        }
        
        tail.next = second;
        return head;
    }
}
