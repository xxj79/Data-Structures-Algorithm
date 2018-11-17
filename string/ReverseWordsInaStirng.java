package string;

public class ReverseWordsInaStirng {
    public String reverseWords(String s) {
        String[] a = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=a.length-1;i>0;i--){
            sb.append(a[i] + ' ');
        }
        return sb.append(a[0]).toString();
    }
}
