package sort;

public class QuickSort {
    
    private int[] a;
    
    public void sort(int[] a){
	if(a == null || a.length<=1) return;
	this.a = a;
	quickSort2(0, a.length-1);
    }
    
    //Scheme 1
    private void quickSort2(int low, int high){
	if(low>=high) return;
	int i = low, p = a[high];
	for(int j = low;j<high;j++){
	    if(a[j] < p){
		swap(i++, j);
	    }
	}
	swap(i, high);
	quickSort2(low, i-1);
	quickSort2(i+1, high);
    }
    
    //Scheme 2 
    private void quickSort(int low, int high){
	if(low>=high) return;
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
	}//Notice i will be the return value for partition() method if needed (ex: for quickSelect)
	
	quickSort(low, j);
	quickSort(i, high);
    }
    
    
    
    
    private void swap(int i, int j){
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
    
    public static void main(String[] args){
	int[] input = {1,2,4,1,5,3,8,1,9};
	QuickSort qs = new QuickSort();
	qs.sort(input);
	
	for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
