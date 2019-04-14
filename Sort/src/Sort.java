public class Sort {
    //冒泡排序
    //返回运行时间long
    public static long BubbleSort(int[] target){
        long l1 = System.currentTimeMillis();
        //System.out.println("l1: "+ l1);
        for (int i = 0; i < target.length - 1 ; i++) {
            for (int j = i; j < target.length ; j++) {
                if (target[i] > target[j]) {
                    swap(target, i, j);
                }
            }
        }
        long l2 = System.currentTimeMillis();

        return l2 - l1;
        //System.out.println("l2: "+ l2);
        //System.out.println(" bubbleSort take time = " + (l2 -l1));
    }

    //加入flag 标志量
    public static long BubbleSort2(int[] target){
        long l1 = System.currentTimeMillis();

        Boolean flag  = true;
        //System.out.println("l1: "+ l1);
        for (int i = 0; i < target.length - 1 && flag ; i++) {
            flag = false;
            //flag 在j的遍历中，如果仍旧是flase，表示j之中没有发生交换，后面的已经完全排序好了，就不需要进行之后的排序
            for (int j = target.length - 1; j > i ; j--) {
                if (target[j] < target[j-1])
                swap(target, j, j-1);
                flag = true;
            }

            //从大到小
//            for (int j = i; j < target.length - 1 ; j++) {
//                if (target[j] < target[j+1]){
//                    swap(target, j, j+1);
//                    flag = true;
//                }
//            }
        }
        long l2 = System.currentTimeMillis();
        //System.out.println("l2: "+ l2);
       // System.out.println(" bubbleSort2 take time = " + (l2 -l1));
        return l2 - l1;
    }

    //选择排序
    public static long SelectSort(int[] target){

        long l1 = System.currentTimeMillis();

        //将未排序队列中挑选出一个最小的值，加入已经排序好的队列中

        for (int i = 0; i < target.length - 1; i++) {
            int minIndex = getMin(target,i);
            swap(target,i,minIndex);
        }

        long l2 = System.currentTimeMillis();
        
        return (l2 - l1);
    }

    //归并排序
    public static long mergeSort(int[] target){
        long l1 = System.currentTimeMillis();
        int[] tmp = new int[target.length];
        MergeSort(target,0,target.length - 1,tmp);
        long l2 = System.currentTimeMillis();
        return l2 - l1;
    }

    private static void MergeSort(int[] target, int start, int end, int[] tmp) {
        //递归出口,当元素值包含一个，不需要分解
        if (start < end){
            int mid  = (end + start)/2;
            //[start,mid] [mid+1 ,end]

            //递归左表
            MergeSort(target,start,mid,tmp);
            //递归右表
            MergeSort(target,mid+1,end,tmp);
            //当左右表有序了,联合左右表
            mergeList(target,start,mid,end,tmp);
        }




    }

    private static void mergeList(int[] target, int start, int mid, int end, int[] tmp) {
        int lstart = start;
        int lend = mid;

        int rstart = mid + 1;
        int rend = end ;

        int tmpIndex = start;

        //lstart and rstart 分别指向表中待比较的元素
        while(lstart <= lend && rstart <= rend){
            if (target[lstart]< target[rstart]){
                tmp[tmpIndex++] = target[lstart++];
            }else {
                tmp[tmpIndex++] = target[rstart++];
            }
        }
        //当右表已经没有元素，左表仍然有元素，直接加入
        while(lstart <= lend ){
            tmp[tmpIndex++] = target[lstart++];
        }

        while(rstart <= rend){
            tmp[tmpIndex++] = target[rstart++];
        }

        for (int i = start; i <= end ; i++) {
            target[i] = tmp[i];
        }

    }


    //插入排序
    //往前找找到比自己大的数，覆盖自己
    public static long insertSort(int[] target){
        int i ,j;
        long l1 = System.currentTimeMillis();

        for (i = 1; i < target.length; i++) {
            //每一个i表示一个带插入元素的下标
            int tmp = target[i];
            //
            for ( j = i - 1; j >= 0 && tmp < target[j] ; j--) {
                target[j+1] = target[j];
            }
            target[j+1] = tmp;
        }

        long l2 = System.currentTimeMillis();
        return l2 - l1;
    }




    private static int getMin(int[] target, int start) {
        int minIndex = start;
        int min = target[start];
        for (int i = start + 1; i < target.length ; i++) {
            if (target[i] < min){
                min = target[i];
                minIndex = i;
            }
        }
        return minIndex;

    }

    private static void swap(int[] target, int i, int j) {
            int tmp = target[i];
            target[i] = target[j];
            target[j] = tmp;

    }

    //快速排序
    public static void quickSort(int[] target){
      QuickSort(target,0,target.length-1);
    }

    private static void QuickSort(int[] target, int start, int end) {

        //一个元素的时候不需要，递归的出口
        if (start < end){
            int privotIndex = partion(target, start, end);
            QuickSort(target,start,privotIndex-1);

            QuickSort(target,privotIndex + 1,end);

        }

    }

    private static int partion(int[] target, int start, int end) {
        int privot = target[start];
        while(start < end){
            while (start < end && target[end] >= privot) end--;
            target[start] = target[end];
            while(start < end && target[start] < privot) start++;
            target[end] = target[start];
        }
            target[start] = privot;
        return start;
    }


}
