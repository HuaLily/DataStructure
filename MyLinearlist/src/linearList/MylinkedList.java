package linearList;

import java.util.Objects;

public class MylinkedList implements MyLinearList {
    //成员位置内部类
    protected class Node{
        private String item;
        private Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

        public String getItem(){
            return item;
        }
    }

    private Node first;

    private int size;

    private Node last;

    public Node getLast() {
        return last;
    }




    public MylinkedList() {
    }



    @Override
    public boolean add(int index, String item) {
        //检查插入位序是否正确 [0,size)
        rangeCheckForAdd(index);

        // 1.找到前一个结点
        Node preNode = findPreNode(index);
       // System.out.println("preNode:"+ preNode);

        // 2.插入操作
        link(item, preNode);

        //3.size++
        size++;
        return true;
    }

    private void link(String item, Node preNode) {

        //表头插入
        if (preNode == null ){
            first = new Node(item, first);
        }

        //什么都没有的时候创建一个新的,注意last本来为null,现在first = last = new Node
        if (size == 0){
            Node node = new Node(item, null);
            first = node;
            last = node;
        }else{
            //正常插入
            //new 一个插入的节点
            Node insertNode = new Node(item, preNode.next);

            //插入
            preNode.next = insertNode;

            if (preNode.next == null){
                //表示在最后插入
                last = insertNode;
            }

        }
    }

    private Node findPreNode(int index) {
        Node preNode = first;
        int count = 0;
        if (index == 0){
            preNode = null;
        }else{
            while(preNode.next != null && count < index - 1){
                preNode = preNode.next;
                count++;
            }
        }
        return preNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        int count = 1;
        for (Node node = first;count <= size; node = node.next){
            stringBuilder.append(node.item);
            if (count != size){
                stringBuilder.append(",");
            }
            count++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String  outOfBoundsMsg(int index) {
        return "Size = "+ size + ",index = "+ index ;
    }

    @Override
    public String delete(int index) {
        //1.判断删除的合法性
        rangeCheckForDelete(index);

        //2.找到前节点
        Node preNode = findPreNode(index);

        String oldValue = first.item;

        //3.删除
        oldValue = unlink(index, preNode, oldValue);

        //4.size--
        size --;
        return oldValue;
    }

    private String unlink(int index, Node preNode, String oldValue) {
        //（1）当前只有一个元素的时候,删除则为空,删除的值仍然是fist.item
        if (size == 1){
            first = last = null;
        }else{
            //（2）删除头节点，first,删除的值仍然是fist.item
            if (index == 0){
                first = first.next;
            }else{
                //（3）删除尾节点,last需要改变next的值
                if (index == size - 1){
                    last = preNode;
                    last.next = null;
                    oldValue = last.item;
                }else {
                    //（4）其他删除
                    oldValue = preNode.next.item;
                    preNode.next = preNode.next.next;



            }

            }
        }
        return oldValue;
    }

    //循环遍历，找到指定的Index的Node
    private Node findNodeByIndex(int index) {
        Node node = first;
        int count = 0;
        while (node.next != null && count < index){
            //如果是头节点，就直接返回
            if (index == 0){
                break;
            }
            node = node.next;
            count++;
        }

        return node;

    }

    private void rangeCheckForDelete(int index) {
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public boolean change(int index, String new_value) {
        //1.检查位序
        rangeCheckForDelete(index);
        //2.找到当前的节点
        Node prestantNode = findNodeByIndex(index);
        //3.修改
        prestantNode.item = new_value;
        return true;
    }

    @Override
    public String findValueByIndex(int index) {

        //1.检查位序
        rangeCheckForDelete(index);
        //2.找到当前的节点
        Node prestantNode = findNodeByIndex(index);

        return prestantNode.item;
    }

    @Override
    public int findIndexByValue(String value) {
        Node node = first;
        int index = 0;
        while(node.next != null){
           // if (node.item.equals(value)){
            if (Objects.equals(value,node.item)){
                return index;
            }
            node = node.next;
            index++;

        }
        return -1;

    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    //头插法
    public void addHead(String value){
        add(0,value);
    }
    //尾插法
    public void addTail(String value){
        add(size,value);
    }
}
