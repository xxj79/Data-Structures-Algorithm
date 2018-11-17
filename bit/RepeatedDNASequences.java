package bit;

import java.util.*;

//hashing 的艺术，用object（String， array etc） 会占用至少几十个byte的内存，而如果用
//Integer 来做键，只需要4个字节（32bits）， 因此我们想办法把substring转换为一个32bits以内
//的数来表示并存入hashset

//这里由于一共只有四个值，我们只需要两个bits来cover一个DNA键， 长度为10的substirng就需要20个bits
//符合我们的要求。

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> ret = new ArrayList<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for(int i = 0;i<s.length() - 9; i++){
            int key = 0;
            for(int j = i;j<i+10;j++){
                key<<=2;
                key |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(key)&& doubleWords.add(key))
                ret.add(s.substring(i, i+10));
        }
        
        return ret;
    }
}
