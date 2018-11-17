package prob;

import java.util.*;


//¾ÍÊÇFisher-YatesËã·¨
public class ShuffleArray {
    int[] def;
    Random r;
    
    public ShuffleArray(int[] nums){
	def = nums;
	r = new Random();
    }
    
    public int[] reset(){
	return def;
    }
    
    public int[] shuffle(){
	int[] a = def.clone();
	for(int i = a.length - 1; i>=1; i--){
	    int ind = r.nextInt(i+1);
	    int temp = a[i];
	    a[i] = a[ind];
	    a[ind] = temp;
	}
	
	return a;
    }
}
