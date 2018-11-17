package Math;


/*
 * Euclidean algorithm to calculate the greatest common devisor(GCD)
 */
public class GCD {
    public int gcd(int a, int b){
	return b==0 ? a : gcd(b, a%b);
    }
}
