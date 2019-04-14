import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums ={3,2,4};
        int target = 6;
//        int[] answer1 = twosum(nums,target);
//        System.out.println(Arrays.toString(answer1));
        int[] answer = twosum2(nums,target);
        System.out.println(Arrays.toString(answer));
        System.out.println(103);


    }

    private static int[] twosum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1 ; j++) {
                if (nums[i] + nums[j] == target){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
    //用Map完成
    private static int[] twosum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                //答案就只要返回一个数组，之后不需要使用，使用匿名对象节省占空间
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
            //i 是慢慢一个个加上去的，所以才会是最大的那个数，就不需要比较答案的大小
        }
       throw new IllegalArgumentException("No two sum solution!");

    }


}
