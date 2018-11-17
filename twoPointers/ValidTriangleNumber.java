package twoPointers;

import java.util.Arrays;

//�������е����������������߿�ʼ�����м佥����������3sum 
public class ValidTriangleNumber {
    public int triangleNumber(int[] a){
	Arrays.sort(a);;
	int ret = 0, n = a.length;
	for(int i = 2;i<n;i++){
	    int lo = 0, hi = i-1;
	    while(lo<hi){
		if(a[lo]+a[hi] > a[i]){
		    ret+=hi-lo;
		    hi--;
		}
		else lo++;
	    }
	}
	return ret;
    }
}
