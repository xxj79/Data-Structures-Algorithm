package stack;

import java.util.*;


/*
 * "." means stay in current dir, just skip
 * ".." means goes back to parent dir. pop()
 */
public class SimplifyUnixPath {
    public String simplifyPath(String path){
	Deque<String> stack = new ArrayDeque<>();
	Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
	for(String dir : path.split("/")){
	    if(dir.equals("..") && !stack.isEmpty())
		stack.pop();
	    if(!skip.contains(dir)) stack.push(dir);
	}
	String ret = "";
	for(String dir : stack) ret = "/" + dir + ret;
	return ret.isEmpty() ? "/" : ret;
    }
}
