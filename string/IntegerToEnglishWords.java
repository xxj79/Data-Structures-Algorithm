package string;

public class IntegerToEnglishWords {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper(int num) {
        String ret = new String();
        if(num < 10) ret = belowTen[num];
        else if(num < 20) ret = belowTwenty[num%10];
        else if(num < 100) ret = belowHundred[num/10] + " " + belowTen[num%10];
        else if(num < 1000) ret = helper(num/100) + "Hundred" + helper(num%100);
        else if(num < 1000000) ret = helper(num/1000) + "Thousand" + helper(num%1000);
        else if(num < 1000000000) ret = helper(num/1000000) + "Million" + helper(num%1000000);
        else ret = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return ret.trim(); //eliminate spaces in front and end
    }
}
