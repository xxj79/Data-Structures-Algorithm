package sort;


/*
 * Two pass counting sort is straight forward.
 * 
 * Below is a one pass solution with constant space
 */
public class SortTheColors {
    public void sortColors(int[] A){
	if(A==null || A.length < 2) return;
	int low = 0;
	int high = A.length - 1;
	
	for(int i = low;i<=high;){
	    if(A[i] == 0){
		int temp = A[i];
		A[low] = temp;
		i++;
		low++;
	    }
	    else if(A[i] == 2){
		int temp = A[i];
		A[i] = A[high];
		A[high] = temp;
		high --; //don't increment i here, since the element we put 
			//here is from the right, which is new to us.
	    }
	    else
		i++;
	}
    }
}
