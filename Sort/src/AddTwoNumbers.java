import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
//
//        ListNode L1 = new ListNode(2);
//        ListNode L2 = new ListNode(4);
//        ListNode L3 = new ListNode(3);
//        ListNode L4 = new ListNode(5);
//        ListNode L5 = new ListNode(6);
//        ListNode L6 = new ListNode(4);
//
//
//        L1.next = L2;
//        L2.next = L3;
//
//        L4.next = L5;
//        L5.next = L6;

        ListNode L1 = new ListNode(9);

        ListNode L = new ListNode(1);
        ListNode L4 = L;
        for (int i = 1; i < 10 ; i++) {
            L.next = new ListNode(9);
            L = L.next;
        }

      ListNode answer = addTwoNumbers(L1,L4);
       // int answer = addTwoNumbers(L1,L4);
      System.out.println(answer);

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      long num1 = getInter(l1);
        System.out.println("num1:"+num1);
      long num2 = getInter(l2);
        System.out.println("num2:"+num2);

      long sum = num1 + num2;


      ListNode answer = ToListNode(sum);
      return answer;
      //  return sum;

    }

    private static ListNode ToListNode(long num) {
//        String s = Integer.toString(num);
//        System.out.println("int to string sum = "+ s);
//        String[] split = s.split("");
//        System.out.println("split= "+ Arrays.toString(split));
//        ListNode listNode = new ListNode(Integer.parseInt(split[0]));
//        ListNode firstNode = listNode;
//            for (int i = 1; i < s.length() ; i++) {
//                listNode.next = new ListNode(Integer.parseInt(split[i]));
//                listNode = listNode.next;
//            }
        System.out.println("sum="+num);
        ListNode listNode = new ListNode((int) num % 10);
       // System.out.println(num%10);
        ListNode firstNode = listNode;
        while(num >= 10){
            num = (num - (num % 10))/10;
           // System.out.println(num);
            listNode.next = new ListNode((int)num % 10);
            listNode = listNode.next;
        }

        return  firstNode;

    }



    private static long getInter(ListNode l) {
        int x = 0;
        long num = 0;
        while(l != null){
            num += l.val * (int)(Math.pow(10,x));
            x ++;
            l = l.next;

        }
        return num;
    }
}
