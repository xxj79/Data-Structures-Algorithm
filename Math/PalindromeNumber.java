package Math;

/*
 * Convert int to string is easy but comsume extra space
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x){
	if(x<0 || (x!=0 && x%10==0)) return false;
	
	if(x==0|| x<10) return true;
	
	int rev = 0, p = x;
	while(x>0){
	    rev = 10*rev+x%10;
	    x/=10;
	}
	return rev==p;
    }
}
