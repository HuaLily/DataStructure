public class BinarySearch {
    public int binarysearch(int[] target,int element){
        int start = 0;
        int end = target.length - 1;
        while(start < end){
            int mid = (start + end)/2;
            if (target[mid] == element){
              return mid;
            }else if (target[mid]> element){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
