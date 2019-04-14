public class Test {
    public static void main(String[] args) {
        char[] pre = {'A','B','E', 'K', 'L', 'F', 'D', 'H', 'J'};
        char[] mid = {'K', 'E', 'L', 'B', 'F', 'A', 'H', 'D', 'J'};

        BitTree bitTree = new BitTree();
        BitTree2 bitTree2 = new BitTree2();
        bitTree2.build(pre,mid);


       bitTree.preOrder(bitTree.build(pre,mid));
        System.out.println();
       bitTree.midOrder( bitTree.build(pre,mid));
        System.out.println();
       bitTree.laterOrder( bitTree.build(pre,mid));
        System.out.println();
        bitTree.BFS(bitTree.build(pre,mid));





    }
}
