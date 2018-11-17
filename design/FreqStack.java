package design;

import java.util.*;
import java.util.HashMap;

public class FreqStack {
    TreeMap<Integer, Set<Integer>> tm;
    Map<Integer, Integer> map;
    Deque<Integer> stack;
    
    public FreqStack() {
        map = new HashMap<>();
        tm = new TreeMap<>();
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        int num = map.getOrDefault(x, 0);
        map.put(x, num+1);
        
        
        Set<Integer> rec = tm.getOrDefault(num, new HashSet<>());
        if(rec.contains(x)) rec.remove(x);

        Set<Integer> nrec = tm.getOrDefault(num+1, new HashSet<>());
        nrec.add(x);
        tm.put(num+1, nrec);
    }
    
    public int pop() {
        Integer mf = tm.lastKey();
        Set<Integer> set = tm.get(mf);
        Deque<Integer> temp = new ArrayDeque<>();
        while(!stack.isEmpty() && !set.contains(stack.peek())) temp.push(stack.pop());
        
        int max = stack.pop();
        map.put(max, map.get(max) - 1);

        set.remove(max);
        Set<Integer> newset = tm.getOrDefault(mf-1, new HashSet<>());
        newset.add(max);
        tm.put(mf-1, newset);
        
        
        while(!temp.isEmpty()) stack.push(temp.pop());
        
        return max;
    }
    
    public static void main(String[] args){
	FreqStack a = new FreqStack();
	a.push(4);
	a.push(3);
	a.push(2);
	a.push(5);
	a.push(4);
	a.push(5);
	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a.pop());
    }
}
