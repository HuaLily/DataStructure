import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class SoetTest {
    public static void main(String[] args) {
        int[] inflate = inflate(10);
//        int[] inflate2 = inflate.clone();
//        int[] inflate3 = inflate.clone();
//        int[] inflate4 = inflate.clone();
        System.out.println("Before:"+Arrays.toString(inflate));
//
//        long bubbleSort = Sort.BubbleSort(inflate);
//        System.out.println("BubbleSort:"+ Arrays.toString(inflate));
//        System.out.println("BubbleSort take time = "+ bubbleSort);
//
//        long bubbleSort2 = Sort.BubbleSort2(inflate2);
//        System.out.println("BubbleSort2:"+ Arrays.toString(inflate2));
//        System.out.println("BubbleSort2 take time = "+ bubbleSort2);
//
//        long selectSort = Sort.SelectSort(inflate3);
//        System.out.println("SelectSort:"+ Arrays.toString(inflate3));
//        System.out.println("SelectSort takes time = "+ selectSort);
//
//        long insertSort = Sort.insertSort(inflate4);
//        System.out.println("insertSort:"+ Arrays.toString(inflate4));
//        System.out.println("insertSort takes time = "+ insertSort);
       //Sort.mergeSort(inflate);
       // System.out.println("MergeSort:"+Arrays.toString(inflate));
       // System.out.println(9/2);
//        Sort.quickSort(inflate);
//        System.out.println("quickSort:"+Arrays.toString(inflate));
//
//        MyHeap myHeap = new MyHeap(inflate);
////        myHeap.printHeapGraphic();
//        myHeap.headfsort();
//        System.out.print("heapsort:");
//        myHeap.printHeap();

        //测试二分搜索
        Arrays.sort(inflate);
        System.out.println("Array.sort:" + Arrays.toString(inflate));
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarysearch(inflate,1));

    }
    public static int[] inflate(int capacity){
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            //生成【0，100）的随机整数
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
