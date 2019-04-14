package constraint_linearlist;

public interface MyQueue {
    //入队列
    public void enQueue(String e);

    //出队列
    public  String deQueue() throws EmptyQueueException;

    //返回队头元素
    public String peek();

    //判空
    public boolean isEmpty();

}
