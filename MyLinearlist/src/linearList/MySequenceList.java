package linearList;

import java.util.Arrays;
import java.util.Objects;

public class MySequenceList implements MyLinearList {
    private String[] items;
    private int size;
    private static  int default_size = 10;
    private static int Max_size = Integer.MAX_VALUE;

    @Override
    public String toString() {
       if (size == 0 ){
           return "[]";
       }

        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size ; i++) {
            stringBuilder.append(items[i]);
            if (i != size-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //默认创建
    public MySequenceList() {
        items = new String[default_size];
        size = 0;
    }

    //用户指定大小创建
    public MySequenceList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("illegal capacity ,capacity = "+ capacity );
        }
        items = new String[capacity];
        size = 0;
    }

    @Override
    public boolean add(int index, String newitem) {
        //1.判断index是否合法
            checkIndexForAdd(index);

        // 2.确保当前数组有空间
            ensureCapacity( size + 1);
                //空间不够的话，那就扩容
        //3.插入这个数，移位
        int MoveNum = ( size - 1) - index + 1;
        if (MoveNum != 0){
            System.arraycopy(items,index,items,index + 1,MoveNum);
        }
        items[index] = newitem;
        //4.size++
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        //1.判断是否需要扩容
        if (minCapacity - items.length > 0){
            //扩容
            grow(minCapacity);
        }
    }

    //扩容
    private void grow(int minCapacity) {
        //一次扩以前的一半
        int oldCapacity = size;
        //注意右移运算的优先级，低于算数运算
        int newCapacity = oldCapacity + ( oldCapacity >> 1 );


        //当数组空间被用户指定为1和 0 的时候， newCapacity不变
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }


        if (newCapacity - Max_size > 0){
            newCapacity = hugeCapacity(minCapacity);
        }

//        //开始扩容
//        //1.自己做，new出空间，复制之前的数组到新的数组中
//        String[] tmp = new String[newCapacity];
//
//        for (int i = 0; i < size ; i++) {
//            tmp[i] = items[i];
//        }
//        items = tmp;

        //2.api

        items = Arrays.copyOf(items,newCapacity);

    }

    //扩容的空间会达到最大的情况
    private int hugeCapacity(int minCapacity) {

//        //1.数组还有空间
//        if (Max_size - minCapacity > 0){
//            return Max_size;
//        }else {
//            //2.数组已经达到极限 max_size - minCapacity <= 0
//            throw new OutOfMemoryError();
//        }
    //当前已经满了
        if(minCapacity < 0){
            throw new OutOfMemoryError();
        }
    //还有一定的空间达到满
        return Max_size;
    }

    //检查插入位序是否正确
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(OutOfBoundMsg(index));

        }
    }

    private String OutOfBoundMsg(int index) {
        return "size = "+ size + "and you choose index = "+ index;
    }


    @Override
    public String delete(int index) {
        //1.检查删除位序 <0 or >= size
        checkIndexForDelete(index);
        //2.删除
        String deleteValue = items[index];
        System.arraycopy(items,index+1,items,index,size- index -1);

        return deleteValue;
    }

    private void checkIndexForDelete(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException(OutOfBoundMsg(index));
        }
    }

    @Override
    public boolean change(int index, String new_value) {
        //1.判断位序是不是合法
        checkIndexForDelete(index);

        //2.修改
        items[index] = new_value;
        return true;
    }



    @Override
    public String findValueByIndex(int index) {

        return items[index];
    }

    @Override
    public int findIndexByValue(String value) {
        //1.如果Value 是null
        if (value == null ){
            for (int i = 0; i < size ; i++) {
                if (items[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i <size; i++) {
                if (value.equals(items[i])){
                    return i;
                }

            }
        }

       // Objects.equals()
        //  return (a == b) || (a != null && a.equals(b));


        for (int i = 0; i <size; i++) {
            if (Objects.equals(value,items[i]))
                return i;

        }
        return -1;





    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;


    }

    @Override
    public int getSize() {
        return size;
    }
}
