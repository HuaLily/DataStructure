import java.util.Arrays;

public class MyHeap {
    int[] elements;
    int size;

    //根据用户给的数组初始化,堆的不是以0为Index开头，而是以1开始，并且初始化大小
    public MyHeap(int[] target){

        //扩容一个
        elements = Arrays.copyOf(target,target.length + 1);
        //整体往后移动一位
        System.arraycopy(elements,0,elements,1,target.length);

        size = target.length;
        //建堆
        heapify();
    }

    private void heapify() {
        //建堆的过程：由第一个不是叶子节点开始往前fixDown
        //第一个不是叶子节点的index = size/2
        for (int i = size/2; i >= 1 ; i--) {
            fixdown(i,size);
        }
    }
    //对指定的位置做fixdown操作
    private void fixdown(int index, int size) {

        for (int i = 2 * index ; i <= size ; i *= 2) {
            //1.取左右孩子中的大者，并用i指向
            if ( i+1 <= size && elements[i+1] > elements[i]){//当父亲节点有右节点，且右节点大于左节点
                i++;
            }
            //2.将左右孩子中的大者和父亲节点交换
            if (elements[i] > elements[index]){
                swap(elements,i,index);
                index = i;
            }else{
                break;
            }

        }
    }
    private  void swap(int[] target, int i, int j) {
        int tmp = target[i];
        target[i] = target[j];
        target[j] = tmp;

    }

    public void printHeap(){
        for (int i = 1; i <= size ; i++) {
            System.out.print(elements[i]+" ");
        }
        System.out.println();

    }

    public void printHeapGraphic() {

        PrintHeapTree printHeapTree = new PrintHeapTree(elements);
        System.out.println(printHeapTree.printFancyTree());
    }

    public void headfsort(){
        for (int i = size; i >= 1 ; ) {
            swap(elements,1,i);
            i--;
            fixdown(1,i);
        }
    }


}
