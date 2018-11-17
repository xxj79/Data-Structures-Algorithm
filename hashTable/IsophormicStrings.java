package hashTable;

public class IsophormicStrings {
    //������⣬ÿ��string��һ��char��Ӧһ������string���char
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        //ÿ����һ��char�� �ֱ��ڸ���map����¸���char���ֵ�index�� ÿ��check����֮ǰ��index�Ƿ����
        for(int i = 0; i<s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = map2[t.charAt(i)] = i+1;
        }
        
        return true;
    }
}
