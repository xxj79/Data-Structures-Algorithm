package test;

import java.util.*;

public class SuperStack {
    Deque<Integer> s1;
    Deque<Integer> s2;
    
    SuperStack(){
	s1 = new ArrayDeque<>();
	s2 = new ArrayDeque<>();
    }    
    
    boolean isEmpty(){
	return s1.isEmpty();
    }
    
    void push(int n){
	s1.push(n);
    }
    
    int pop(){
	return s1.size() == s2.size() ? s1.pop() + s2.pop() : s1.pop();
    }
    
    void inc(int e, int k){
	int size = s2.size();
	for(int i = Math.min(e, size); i>0; i--){
	    s2.push(k + s2.pollLast());
	}
	
	if(e>size){
	    for(int i = e-size; i>0;i--){
		s2.push(k);
	    }
	}
	else if(size > e){
	    for(int i = size - e; i>0; i--){
		s2.push(s2.pollLast());
	    }
	}
    }
}
