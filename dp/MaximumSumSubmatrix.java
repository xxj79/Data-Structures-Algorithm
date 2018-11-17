package dp;

public class MaximumSumSubmatrix {
    public int findMax(int[][] a){
	if(a.length == 0) return 0;
	int m = a.length, n = a[0].length, ret = Integer.MIN_VALUE;
	int hi= 0 , lo = 0;
	
	for(hi = 0;hi<m;hi++){
	    int[] row = new int[n];
	    for(lo = hi;lo<m;lo++){
		for(int i=0;i<n;i++){
		    row[i]+=a[lo][i];
		}
		
		int temp = 0, sum = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
		    temp = row[i] + (temp<0 ? 0 : temp);
		    sum = Math.max(sum, temp);
		}
		ret = Math.max(ret, sum);
	    }
	}
	
	return ret;
    }
    
    public static void main(String[] args){
	MaximumSumSubmatrix obj = new MaximumSumSubmatrix();
	int[][] a = new int[][]{{2,1,-3,-4,5}, {0,6,3,4,1}, {2,-2,-1,4,-5}, {-3,3,1,0,3}};
	System.out.println(obj.findMax(a));
    }
}
