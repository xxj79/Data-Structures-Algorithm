package string;

public class ReverseWordsInaStringII {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
		int r = 0;
		while(r<s.length){
			int l = r;
			while(r<s.length&&s[r]!=' ')
				r++;
			reverse(s, l, r-1);
			r++;
		}
    }
    
    void reverse(char[] s, int l, int r){
        while(l<r){
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}
