package design;

class Reader4{
    public int read4(char[] buf){
	return 4;
    }
}

/*
 * The read4 API is defined in the parent class Reader4.
 * 	int read4(char[] buf);
 */
public class ReadNCharsGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of chars to read
     * @return    The number of chars read 
     */
    
    
    //total as the pointer in result array buf
    //append char every time call a new read4
    public int read(char[] buf, int n){
	boolean end = false;
	int total = 0; // count of chars read so far
	char[] temp = new char[4];
	
	while(!end && total < n){
	    int count = read4(temp);
	    
	    end = count<4;//whether end of file
	    
	    count = Math.min(count, n - total);// make sure no overhead
	    
	    for(int i=0;i<count;i++)
		buf[total++] = temp[i];
	}
	return total;
	
    }
}
