package constraint_linearlist;

public class Test {
    public static void main(String[] args) throws EmptyQueueException {
        //测试MysquentialQueue
        MySquentialQueue mySquentialQueue = new MySquentialQueue();
        testSequentialQueueEnqueue(mySquentialQueue);

        String s = mySquentialQueue.deQueue();
        System.out.println("dequeue = "+ s +", mysequentialQueue = "+ mySquentialQueue);

    }

    private static void testSequentialQueueEnqueue(MySquentialQueue mySquentialQueue) {
        for (int i = 0; i < 9 ; i++) {
            mySquentialQueue.enQueue(""+i);
        }
        System.out.println("test enQueue: add 1-8"+ mySquentialQueue);

        for (int i =110; i <121 ; i++) {
            mySquentialQueue.enQueue(""+ i );
        }
        System.out.println("test enQueue: add 110- 120"+ mySquentialQueue );
    }
}
