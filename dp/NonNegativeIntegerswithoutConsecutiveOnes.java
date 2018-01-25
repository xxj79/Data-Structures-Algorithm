package dp;

/*
 * Find total number of integer of length I without consecutive 1
 * in its binary representation:

Let a[i] be the number of binary strings of length i which do not 
contain any two consecutive 1¡¯s and which end in 0. Similarly, let 
b[i] be the number of such strings which end in 1. We can append 
either 0 or 1 to a string ending in 0, but we can only append 0 to 
a string ending in 1. This yields the recurrence relation:
    
    	a[i] = a[i - 1] + b[i - 1]
	b[i] = a[i - 1] 
		
The base cases of above recurrence are a[1] = b[1] = 1. 
The total number of strings of length i is just a[i] + b[i].
*/
public class NonNegativeIntegerswithoutConsecutiveOnes {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();
        
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        
        int result = a[n - 1] + b[n - 1];
        
        //From MSB to LSB, if we found consecutive 1s, stop, since all other numbers
        //are equal or less than it; If we found consecutive 0s, we need to minus the
        // 01 case (bigger than 00), which is b[i]
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }
        
        return result;
    }
}
