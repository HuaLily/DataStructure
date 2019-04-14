package constraint_linearlist;

import java.util.Arrays;

public class MySquentialQueue implements MyQueue {

    private int front;
    private int rear;
    private String[] items;
    private int default_size = 10;
    private int Max_size = Integer.MAX_VALUE;

    //初始化构造
    public MySquentialQueue() {
        items = new String[default_size];
        front = rear = 0;
    }

    @Override
    public void enQueue(String e) {
        //1.(不用看插入的位序是不是合法了)，先确保能加入，不够就扩容
        //这里要确保有多余的两个空间
        //一个是保证有一个空间可以加
        //一个是保证有一个空间 用来解决rear == front，无法判断是空还是满的问题，有这个一个空间，则能next(rear) == front 为满，rear == front 为空
        ensureCapcity(size()+ 2);

        //2.加入元素

        items[rear] = e;

        //3.size++;

        rear = next(rear);


    }

    private void ensureCapcity(int minCapcity) {

        //本人的做法是看保证最小的容量和数组大小比较
        // if (minCapcity - items.length > 0){

        //队列满了要扩容
        if (next(rear) == front){
            grow(minCapcity);
        }

    }

    private void grow(int minCapcity) {
        int oldCapcity = items.length;
        int newCapcity = oldCapcity + (oldCapcity >> 1);

        //当只有1或0个元素的时候 ，newCapcity并没有变化
        if ( newCapcity - oldCapcity <= 0){
            newCapcity = minCapcity;
        }

        //当扩容超过最大的容量,直接给到最大的能够给的空间
        if ( newCapcity - Max_size > 0){
            newCapcity = Max_size;
        }

        //和顺序线性表不同，数组空间虽然扩大了，但是front 和 rear 的位置没有变化，则一直表示的是满的空间
        //效果如下图表示：
        /***
         ——  ——  ——  ——  ——
        |////|/////| rear|front|////|》》》扩展的空间
         ——  ——  ——  ——  ——
          0     1     2    3     4
         ***/

        //所以要模仿一下Arrays.copyof(items,newCapcity)函数，改变一下copy函数
        String[] tmp = arrayCopy(items,newCapcity);

        items = tmp;


    }

    private String[] arrayCopy(String[] items,int newCapcity) {
      String[] newArray = new String[newCapcity];
      int i = front;
      int decpos = 0;
      while(i != rear){
          newArray[decpos++] = items[i];
          i = next(i);
      }
      return newArray;
    }

    private int next(int index) {
        return (index + 1) % items.length;
    }

    private int size(){
        return (rear - front + items.length) % items.length;
    }

    @Override
    public String deQueue() throws EmptyQueueException {
        //1.如果没有元素，直接报错
        if (size() == 0){
            throw new EmptyQueueException("Empty Queue!");
        }

        //2.头出元素
        String oldvalue = items[front];
        front = next(front);

        return oldvalue;
    }

    @Override
    public String peek() {

        String oldvalue = items[front];

        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public String toString() {
        if (size() == 0 ){
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        int i = front;
        while (i != rear){
            stringBuilder.append(items[i]);
            if (next(i) != rear ){
                stringBuilder.append(",");
            }
            i = next(i);
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
