package stack;

//�Ӻ���ǰ��ջ��ÿ��ջ����list������integerʱ��pop���listȻ�������ͬ���ĴӺ���ǰ��ջ��
//ֱ��ջ����һ������hasNext()����true

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
