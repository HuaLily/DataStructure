package constraint_linearlist;

import linearList.MylinkedList;

import java.util.EmptyStackException;

public class MyLinkedStack extends MylinkedList implements MyStack {

    @Override
    public void push(String e) {
        addTail(e);
    }

    @Override
    public String pop() {
        return delete(getSize()-1);
    }

    @Override
    public String peek() {
        if (isempty()){
            throw new EmptyStackException();
        }
        return  getLast().getItem();
    }

    @Override
    public boolean isempty() {
        return false;
    }
}
