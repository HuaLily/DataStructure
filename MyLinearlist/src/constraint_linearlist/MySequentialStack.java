package constraint_linearlist;
import linearList.MySequenceList;

import java.util.EmptyStackException;

public class MySequentialStack  extends MySequenceList implements MyStack {
    @Override
    public void push(String e) {
        add(getSize(),e);
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
        return findValueByIndex(getSize()-1);
    }

    @Override
    public boolean isempty() {
        return getSize() == 0;
    }
}
