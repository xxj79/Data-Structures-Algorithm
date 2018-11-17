package array;

/*
 * Take away, swapping is a technique for keeping constant space
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A){
        int i = 0;
        while(i<A.length){
            if(A[i] == i+1 || A[i]<=0 || A[i] > A.length) i++;
            
            //Place every element into its right position
            //Notice don't increment i here, keep swapping until already correct
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1); 
            else i++;
        }
        i = 0;
        while(i<A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
