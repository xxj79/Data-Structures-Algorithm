package prob;
import java.util.*;

public class RandomPickIndex {
    int[] a;
    Random r;
    
    public RandomPickIndex(int[] nums){
	a = nums;
	r =  new Random();
    }
    
    public int pick(int target){
	int ret = -1, len = 0;
	for(int i = 0; i<a.length; i++){
	    if(a[i] != target) continue;
	    if(r.nextInt(++len) < 1) ret = i;
	}
	
	return ret;
    }
}
