package string;

public class StringCompressionInPlace {
    public int compress(char[] chars){
	int index = 0, i = 0;
	while(i < chars.length){
	    char c = chars[i];
	    int count = 0;
	    
	    //Nice scan trick
	    while(i<chars.length && chars[i] == c){
		i++;
		count++;
	    }
	    
	    chars[index++] = c;
	    if(count!=1)
		for(char ch : Integer.toString(count).toCharArray())
		    chars[index++] = ch;
	}
	return index;
    }
}
