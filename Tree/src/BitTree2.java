public class BitTree2 {

    private TreeNode root;


    public void build(char[] pre, char[] mid) {
        root = buildTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }


    // 前提条件，树中不存在重复元素
    //由先序遍历序列和中序遍历序列构造二叉树
    private TreeNode buildTree(char[] pre, int lPre, int rPre, char[] mid, int lMid, int rMid) {
        //   lchild      item    rchild
        //1.在先序遍历序列中，找到当前这颗树的根节点
        char root = pre[lPre];   // A

        //2.在中序遍历序列中，根据先序遍历序列中的根节点，查找其在中序遍历序列中的位置
        int rootIndex = getRootIndex(mid, lMid, rMid, root);

        if(rootIndex == -1) {
            throw new IllegalArgumentException("illegal argument");
        }

        //计算当前这棵树的左右子树的个数
        // [          root          ]
        //  lMid     rootIndex  rMid
        //左子树 [lMid, rootIndex-1]
        int lNum =  rootIndex - lMid; //(rootIndex - 1) - lMid + 1

        //右子树的个数 [rootIndex + 1, rMid]
        int rNum = rMid - rootIndex; //rMid - (rootIndex + 1) + 1

        //开始构建，当前根节点的左子树和右子树

        //先构建左子树
        TreeNode lchild;

        if(lNum == 0) {
            //说明，以当前节点为根的树，没有左子树
            lchild = null;
        } else {
            //当前这个树的左子树，仍然是一棵树，递归构造当前这颗树的左子树

            // x - （lPre + 1） + 1 = lNum
            // x = lPre + lNum
            lchild = buildTree(pre, lPre + 1, lPre + lNum, mid, lMid, rootIndex - 1);
        }

        TreeNode rchild;
        //构建右子树
        if(rNum == 0) {
            rchild = null;
        } else {

            //当前节点的右子树，仍然包含很多节点，需要递归的构造其右子树
            rchild = buildTree(pre, lPre + lNum + 1, rPre, mid, rootIndex + 1, rMid);

        }
        return  new TreeNode(root, lchild, rchild);
    }

    private int getRootIndex(char[] mid, int lMid, int rMid, char root) {

        for (int i = lMid; i <= rMid; i++) {

            if(mid[i] == root) {
                return i;
            }
        }

        return -1;

    }


    //二叉树中每一个节点的结构
    private  class TreeNode {
        //节点中所存储的数据
        char item;

        //指向左孩子节点
        TreeNode lChild;

        //指向右孩子节点
        TreeNode rChild;

        public TreeNode(char item, TreeNode lChild, TreeNode rChild) {
            this.item = item;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }


    public  void preTraverse() {
        preOrder(root);
    }


    public void midTraverse() {
        midOrder(root);
    }

    public void postTraverse() {
        postOrder(root);
    }



    // 1. 先序遍历   DLR
    private void preOrder(TreeNode root) {

        if( root != null) {
            //先访问根节点
            System.out.print(root.item + " ");

            //递归访问左子树
            preOrder(root.lChild);

            //递归访问右子树
            preOrder(root.rChild);
        }

    }

    //中序遍历   LDR
    public void midOrder(TreeNode root) {

        if(root != null) {
            //递归访问左子树
            midOrder(root.lChild);
            //访问根
            System.out.print(root.item + " ");

            //递归访问右子树
            midOrder(root.rChild);
        }

    }

    //后续遍历
    // LRD
    public void postOrder(TreeNode root) {

        if(root != null) {

            //递归访问左子树
            postOrder(root.lChild);

            //递归访问右子树
            postOrder(root.rChild);

            //访问根
            System.out.print(root.item + " ");

        }

    }
}
