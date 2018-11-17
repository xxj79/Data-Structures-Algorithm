package sort;


/*
 * This version of implementation is not good.
 * 
 * See KthSmallestElement.java for a easier implementation
 */
public class QuickSelect {
    private int[] a;
    
    public int find(int[] a, int k){
	this.a = a;
	return kthSmallest(0, a.length-1, k);
    }
    private int kthSmallest(int low, int high, int k){
	if(k > 0 && k <= high - low + 1){
	    //Do partition:
    		int i = low;
    		int j = high;
    	
        	int pivot = a[low+(high-low)/2];
        	
        	while(i<=j){
        	    while(a[i]<pivot) i++;
        	    
        	    while(a[j]>pivot) j--;
        	    
        	    if(i<=j) { //Attention: this must be <= !!! Otherwise will STACKOVERFLOW!!!	
        		swap(i, j);
        		i++;
        		j--;
        	    }
        	}
        	
        	//i bucket now holds its correct element.
        	if(i-low == k-1) return a[i];
        	
        	if(i-low > k-1) return kthSmallest(low, i-1, k);
        	
        	return kthSmallest(i+1, high, k-i+low-1);
	}
	return Integer.MAX_VALUE;
    }
    
    private void swap(int i, int j){
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
    
    public static void main(String[] args){
	int[] input = {1,2,4,1,5,3,8,1,9};
	QuickSelect qs = new QuickSelect();
	System.out.println(qs.find(input, 9));
    }
}
