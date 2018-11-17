package stack;

//从后往前入栈，每当栈顶是list而不是integer时，pop这个list然后对它做同样的从后往前入栈，
//直到栈顶是一个数，hasNext()返回true

public class FlattenNestedListIterator {
    /*
    Deque<NestedInteger> stack = new ArrayDeque<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i>=0;i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()) return true;
            stack.pop();
            List<NestedInteger> list = top.getList();
            for(int i = list.size()-1;i>=0;i--)
                stack.push(list.get(i));
        }
        return false;
    }
    */
}
