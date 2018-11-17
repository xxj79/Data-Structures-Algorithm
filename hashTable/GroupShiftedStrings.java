package hashTable;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings){
	List<List<String>> ret = new ArrayList<>();
	Map<String, List<String>> map = new HashMap<>();
	for(String s : strings){
	    String key = getKey(s);
	    List<String> list = map.getOrDefault(key, new ArrayList<>());
	    list.add(s);
            map.put(key, list);
	}
	
	for(List<String> v : map.values()){
            ret.add(v);
        }
        return ret;
    }
    
    private String getKey(String str) {
        char[] charArray = str.toCharArray();
        int offset = str.charAt(0) - 'a';
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] -= offset;
            if (charArray[i] < 'a') charArray[i] += 26;
        }
        return new String(charArray);
    }
}
