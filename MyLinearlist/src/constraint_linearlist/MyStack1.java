package constraint_linearlist;

import linearList.MyLinearList;
import linearList.MylinkedList;

//组合

public class MyStack1 implements MyStack {
    MyLinearList stack;

    public void setStack(MyLinearList stack) {
        this.stack = stack;
    }

    public MyStack1(MyLinearList stack) {
        this.stack = stack;
    }

    @Override
    public void push(String e) {
        stack.add(stack.getSize(),e);
    }

    @Override
    public String pop() {
        return stack.delete(stack.getSize()-1);
    }

    @Override
    public String peek() {
        return stack.findValueByIndex(stack.getSize()-1);
    }

    @Override
    public boolean isempty() {
        return stack.isEmpty();
    }
}
