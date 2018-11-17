package stack;

import java.util.*;

public class VerifyPreorderTraversal {
    
    public boolean verifyPreorder(int[] preorder){
	int low = Integer.MIN_VALUE;
	Deque<Integer> st = new ArrayDeque<>();
	for(int p : preorder){
	    if(p < low) return false;
	    while(!st.isEmpty() && p > st.peek())
		low = st.pop();
	    st.push(p);
	}
	return true;
    }
    
    public boolean verifyPreorderInPlace(int[] preorder){
	int low = Integer.MIN_VALUE, ind = -1;
	for(int p : preorder){
	    if(p<low) return false;
	    while(ind >= 0 && p > preorder[ind]) 
		low = preorder[ind--];
	    preorder[++ind] = p;
	}
	return true;
    }
}
