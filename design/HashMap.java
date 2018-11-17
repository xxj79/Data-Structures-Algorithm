package design;

public class HashMap {
    final Bucket[] map = new Bucket[10000];
    
    public void put(int key, int val){
	int i = hashCode(key);
	if(map[i] == null) map[i] = new Bucket();
	Entry pre = find(map[i], key);
	if(pre.next == null) pre.next = new Entry(key, val);
	else pre.next.val = val;
    }
    
    public int get(int key){
	int i = hashCode(key);
	if(map[i] == null) return -1;
	Entry node = find(map[i], key);
	return node.next == null?-1 : node.next.val;
    }
    
    public void remove(int key){
	int i = hashCode(key);
	if(map[i] == null) return;
	Entry pre = find(map[i], key);
	if(pre.next == null) return;
	pre.next = pre.next.next;
    }
    
    public int hashCode(int i){
	return Integer.hashCode(i);
    }
    
    Entry find(Bucket map, int key){
	Entry node = map.head, pre = null;
	while(node!=null && node.key!=key){
	    pre = node;
	    node = node.next;
	}
	return pre;
    }
    
    class Bucket{
	final Entry head = new Entry(-1, -1);
    }
    class Entry{
	int key, val;
	Entry next;
	
	Entry(int key, int val){
	    this.key = key;
	    this.val = val;
	}
    }
}
