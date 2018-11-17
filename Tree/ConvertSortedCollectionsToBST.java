package Tree;

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){this.val = val;}
}


//Key to this problem is to find Middle element as well as the left and right bound of recursion method
//Use middle element create current node, and assign left and right child using dfs(left, right)

//For array, we simply use index as bound,
//For linked list, we use head and null for initial left and right bound.
public class ConvertSortedCollectionsToBST {
    //LinkedList to BST
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
    
    //Array to BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    
    TreeNode dfs(int[] nums, int l, int r){
        if(l>r) return null;
        
        int m = (l+r)/2;
        TreeNode ret = new TreeNode(nums[m]);
        ret.left = dfs(nums, l, m-1);
        ret.right = dfs(nums, m+1, r);
        
        return ret;
    }
}
