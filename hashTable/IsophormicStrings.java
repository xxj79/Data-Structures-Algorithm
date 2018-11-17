package hashTable;

public class IsophormicStrings {
    //理解题意，每个string里一个char对应一个另外string里的char
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        //每碰到一对char， 分别在各自map里更新各自char出现的index。 每次check两个之前的index是否相等
        for(int i = 0; i<s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = map2[t.charAt(i)] = i+1;
        }
        
        return true;
    }
}
