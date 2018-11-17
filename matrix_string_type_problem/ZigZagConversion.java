package matrix_string_type_problem;

/*
 * Create nRows StringBuilders, and keep collecting characters
 * from original string to corresponding SringBuilder. Just take
 * care of your index to keep them in bound.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows){
	char[] c = s.toCharArray();
	int len = c.length;
	StringBuilder[] sb = new StringBuilder[nRows];
	
	int i = 0;
	while(i<len){
	    for(int idx = 0;idx<nRows && i<len;idx++) // vertically down
		sb[idx].append(c[i++]);
	    for(int idx = nRows - 2; idx >= 1 && i<len;idx--) // obliquely up
		sb[idx].append(c[i++]);
	}
	
	for(int idx = 1;idx<sb.length;idx++)
	    sb[0].append(sb[idx]); //link every row together
	
	return sb[0].toString();
    }
}
