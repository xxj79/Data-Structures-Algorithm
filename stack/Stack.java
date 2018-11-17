package stack;
import java.util.*;

/*
 * Stack implemented by linkedlist always operate on the head of linkedlist (Same as queue, insert at the end
 * and poll from the front)
 */

public class Stack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
