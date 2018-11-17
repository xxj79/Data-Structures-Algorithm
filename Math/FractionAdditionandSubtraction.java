package Math;

//Notice the regex we use:
//    "(?=[+,-])" means: To split the string by character that equals + or -, from the begining
//    of the string, 0 width split(next char is +/-,  we cut between cur and next)

public class FractionAdditionandSubtraction {
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
        String res = "0/1";
        for (String frac : fracs) res = add(res, frac); // add all fractions together
        return res;
    }

    public String add(String frac1, String frac2) {
        String[] s1 = frac1.split("/"), s2 = frac2.split("/");
        
        int n1 = Integer.parseInt(s1[0]), n2 = Integer.parseInt(s2[0]), 
        	d1 = Integer.parseInt(s1[1]), d2= Integer.parseInt(s2[1]);
        
        int numer = n1*d2 + n2*d1, denom = d1*d2;
        String sign = "";
        if (numer < 0) {sign = "-"; numer *= -1;}
        return sign + numer/gcd(numer, denom) 
        	+ "/" + denom/gcd(numer, denom); // construct reduced fraction
    }

    // Computes gcd using Euclidean algorithm
    public int gcd(int x, int y) { return x == 0 || y == 0 ? x + y : gcd(y, x % y); }
}
