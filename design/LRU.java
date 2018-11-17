package design;

import java.util.*;
import java.util.HashMap;

/*
addNode(node) -- add new node after head

removeNode(node) -- directely remove and node anywhere in the list

moveToHead(node) -- first remove() then add()

popTail() -- pop the node at the tail of the list (least used node)
*/
public class LRU {
    class DLinkedNode{
	int key;
	int value;
	DLinkedNode pre;
	DLinkedNode post;
    }
    
    public int numberOfGroup(Set<DLinkedNode> set){
	Map<DLinkedNode, Integer> map = new HashMap<>();
	
	int count = 0;
	for(DLinkedNode node : set){
	    count++;
	    
	    int reduce = map.getOrDefault(node, 0);
	    count -= reduce;
	    
	    if(node.pre!=null)
		map.put(node.pre, map.getOrDefault(node.pre, 0)+1);
	    if(node.post!=null)
		map.put(node.post, map.getOrDefault(node.post, 0)+1);
	}
	
	return count;
    }
    
    /*
     * Always add the new node right after head
     */
    private void addNode(DLinkedNode node){
	node.pre = head;
	node.post = head.post;
	
	head.post.pre = node;
	head.post = node;
    }
    
    /*
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
	DLinkedNode pre = node.pre;
	DLinkedNode post = node.post;
	
	pre.post = post;
	post.pre = pre;
    }
    
    /*
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
	this.removeNode(node);
	this.addNode(node);
    }
    
    /*
     * Pop the current tail
     */
    private DLinkedNode popTail(){
	DLinkedNode res = tail.pre;
	this.removeNode(res);
	return res;
    }
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRU(int capacity){
	this.count = 0;
	this.capacity = capacity;
	
	head = new DLinkedNode();
	head.pre = null;
	
	tail = new DLinkedNode();
	tail.post = null;
	
	head.post = tail;
	tail.pre = head;
    }
    
    public int get(int key){
	DLinkedNode node = cache.get(key);
	if(node == null) return -1;
	
	this.moveToHead(node);
	
	return node.value;
    }
    
    public void set(int key, int value){
	DLinkedNode node = cache.get(key);
	
	if(node == null){
	    DLinkedNode newNode = new DLinkedNode();
	    newNode.key = key;
	    newNode.value = value;
	    
	    this.cache.put(key, newNode);
	    this.addNode(newNode);
	    
	    count++;
	    
	    if(count > capacity){
		//pop the tail
		DLinkedNode tail = this.popTail();
		this.cache.remove(tail.key);
		count--;
	    }
	}
	else{
	    //update the value
	    node.value = value;
	    this.moveToHead(node);
	}
    }
}
