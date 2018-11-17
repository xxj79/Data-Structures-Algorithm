package divideConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//一个重要的发现，magical总是以1开始，以0结束。 然后想到用分治，由大化
public class MagicalBinaryNumber {
    public String magicalString(String s){
	List<String> list = new ArrayList<>();
	int i = 0, count = 0;
	for(int j = 0;j<s.length();j++){
	    char cur = s.charAt(j);
	    if(cur == '1') count++;
	    else count--;
	    if(count == 0){
		list.add("1" + magicalString(s.substring(i+1, j)) + "0");
		i = j+1;
	    }
	}
	Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
	StringBuilder sb = new StringBuilder();
	for(String str : list) sb.append(str);
	return sb.toString();
    }
}


