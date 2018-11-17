package design;

/*
The idea is using two pointers:
buffPtr indicates where we are now in the last time read4 result buffer
buffCnt indicates how many chars are there from the last time read4

Once buffPtr becomes equal to buffCnt, reset buffPtr to 0, which also 
indicates we should make a new read4() call. 

Finally, whenever buffCnt(number of chars read from last reader4() call)
is less than 4, we break out from the loop. 
*/

public class ReadNCharactersGivenRead4II extends Reader4{
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n){
	int ptr = 0;
	while(ptr<n){
	    if(buffPtr == 0) buffCnt = read4(buffer);
	    
	    while(ptr<n && buffPtr<buffCnt)
		buf[ptr++] = buffer[buffPtr++];
	    
	    if(buffPtr == buffCnt) buffPtr = 0;
	    
	    if(buffCnt < 4) break;
	}
	return ptr;
    }
}
