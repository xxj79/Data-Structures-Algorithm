package stack;

import java.util.*;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input){
	Deque<Integer> stack = new ArrayDeque<>();
	stack.push(0); // dummy length;
	int ret = 0;
	for(String s : input.split("\n")){
	    int lev = s.lastIndexOf("\t") + 1;
	    while(lev+ 1<stack.size()) stack.pop();
	    
	    int len = stack.peek() + s.length() - lev + 1;
	    stack.push(len);
	    if(s.contains(".")) ret = Math.max(ret, len - 1);
	}
	return ret;
    }
}
