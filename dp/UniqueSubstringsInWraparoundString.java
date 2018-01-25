package dp;

/*
 * To find the number of unique substrings in the wrap around string,
 * we can just store the longest substring presented in the string that
 * ending with different character (a - z), which will cover all the unique
 * cases.
 */
public class UniqueSubstringsInWraparoundString {
	public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);//try to update
        }
        
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
