package dp;

public class UglyNumberII {
    public int nthUglyNumber(int n){
	int[] ugly = new int[n];
	ugly[0] = 1;
	int p1 =  0, p2 = 0, p3 = 0;
	for(int i=1;i<n;i++){
	    ugly[i] = Math.min(ugly[p1]*2, Math.min(ugly[p2]*3, ugly[p3]*5));
	    if(ugly[i] == ugly[p1]*2) p1++;
	    if(ugly[i] == ugly[p2]*3) p2++;
	    if(ugly[i] == ugly[p3]*5) p3++;
	}
	return ugly[n-1];
    }
}
