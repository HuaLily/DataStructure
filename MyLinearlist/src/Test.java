import linearList.MySequenceList;
import linearList.MylinkedList;

public class Test {
    public static void main(String[] args) {
//        linearList.MySequenceList mySequenceList = new linearList.MySequenceList();
//        System.out.println("is empty:"+mySequenceList.isEmpty());
//        testadd(mySequenceList);
//        testdelete(mySequenceList);
//        testchange(mySequenceList);
//        testFindByValue(mySequenceList);
//        testFindIndexByValue(mySequenceList);
//        System.out.println("is empty:"+mySequenceList.isEmpty());

        MylinkedList mylinkedList = new MylinkedList();
        testLinkedListAdd(mylinkedList);

        testLinkedListDelete(mylinkedList);

        testLinkedListfindIndexByValue(mylinkedList);

        testLinkedListFoundValueByIndex(mylinkedList);

    }

    private static void testLinkedListFoundValueByIndex(MylinkedList mylinkedList) {
        System.out.println("find index = 3,value ="+mylinkedList.findValueByIndex(3));
        System.out.println("find index = 0,value ="+mylinkedList.findValueByIndex(0));
    }

    private static void testLinkedListfindIndexByValue(MylinkedList mylinkedList) {
        int index = mylinkedList.findIndexByValue("1");
        System.out.println("testLinkedListfindIndexByValue find value = 1 ,index ="+index);
        System.out.println("find value = -1,index = "+mylinkedList.findIndexByValue("-1"));
        System.out.println("find value = 7,index = "+mylinkedList.findIndexByValue("7"));
        System.out.println("find value = null,index = "+mylinkedList.findIndexByValue(null));
    }

    private static void testLinkedListDelete(MylinkedList mylinkedList) {
        mylinkedList.delete(0);//0
        mylinkedList.delete(1);//2
        mylinkedList.delete(mylinkedList.getSize()-1);//9
        System.out.println("testdLinkedListDelete:"+ mylinkedList);
    }

    private static void testLinkedListAdd(MylinkedList mylinkedList) {
//        mylinkedList.add(0,"zs");
//        mylinkedList.add(1,"ls");
//        mylinkedList.add(1,"wu");
        for (int i = 0; i < 10; i++) {
            mylinkedList.add(i,""+i);
        }
        System.out.println("testLinkedListAdd:"+mylinkedList);
    }

    private static void testFindIndexByValue(MySequenceList mySequenceList) {
        System.out.println("find value = 7 index =");
        System.out.println(mySequenceList.findIndexByValue("7"));
    }

    private static void testFindByValue(MySequenceList mySequenceList) {
        System.out.println("find index = 1:");
        System.out.println(mySequenceList.findValueByIndex(1));
    }

    private static void testchange(MySequenceList mySequenceList) {
        mySequenceList.change(0,"changed");
        System.out.println("change index = 0 ,value = changed:");
        System.out.println(mySequenceList);
    }

    private static void testdelete(MySequenceList mySequenceList) {
        System.out.println("delete index = 0,value =" + mySequenceList.delete(0));
        System.out.println(mySequenceList);

       // mySequenceList.delete(11);
    }

    private static void testadd(MySequenceList mySequenceList) {
        System.out.println("add 0 to 9:");
        for (int i = 0; i <10 ; i++) {
            mySequenceList.add(i,""+i);
        }
        System.out.println(mySequenceList);
    }
}
