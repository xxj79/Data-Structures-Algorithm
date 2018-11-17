package bit;

import java.util.*;

//hashing ����������object��String�� array etc�� ��ռ�����ټ�ʮ��byte���ڴ棬�������
//Integer ��������ֻ��Ҫ4���ֽڣ�32bits���� ���������취��substringת��Ϊһ��32bits����
//��������ʾ������hashset

//��������һ��ֻ���ĸ�ֵ������ֻ��Ҫ����bits��coverһ��DNA���� ����Ϊ10��substirng����Ҫ20��bits
//�������ǵ�Ҫ��

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
