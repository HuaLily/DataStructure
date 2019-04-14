
import java.util.LinkedList;
import java.util.Queue;

public class BitTree {

    private class TreeNode{
        char item;
        TreeNode lNode;
        TreeNode rNode;

        private TreeNode(char item, TreeNode lNode, TreeNode rNode) {
            this.item = item;
            this.lNode = lNode;
            this.rNode = rNode;
        }
    }

    //由先序和中序确定一个树
    public TreeNode build(char[] pre , char[] mid){

        return Treebuild( pre, 0 , pre.length -1, mid , 0 , mid.length - 1);
    }


    private TreeNode Treebuild(char[] pre, int lpre, int rpre, char[] mid, int lmid, int rmid) {

        //1.由先序序列中确定root
        char root = pre[lpre];

        //2.由root 在中序序列中找到 rootindex
        int rootindex = findRootIndexInMid(root,mid,lmid,rmid);
       // System.out.println("root:"+ root + " , rootindex= " + rootindex);

        if (rootindex == -1 ){
            throw new IllegalArgumentException("illegalArgument!");
        }

        //3.根据rootindex在中序序列中确定左边lnum和右边的个数rnum
        int lnum = rootindex - lmid;
        int rnum = rmid - rootindex;

        //4.根据lnum 和 rnum 来构建左右子树

            //构建左子树
        TreeNode lchild ;

        if (lnum == 0){
            //左子树没有了的情况
            lchild = null;
        }else{
            //左子树仍然是一颗树
            lchild = Treebuild(pre,lpre + 1,lpre+lnum ,mid,lmid,rootindex - 1);
        }

        TreeNode rchild;

        if (rnum == 0 ){
            //右子树没有了的情况
            rchild = null;
        }else{
            rchild = Treebuild(pre,lpre + lnum + 1, rpre , mid ,rootindex + 1 ,rmid);
        }



        return new TreeNode(root,lchild,rchild);

    }
    private int findRootIndexInMid(char root, char[] mid, int lmid, int rmid) {

        for (int i = lmid; i <= rmid ; i++) {
            if (mid[i] == root){
                return i;
            }
        }

        return -1;
    }

    //先序遍历
    public void preOrder(TreeNode root){
        if (root != null){

            System.out.print(root.item + " ");
            preOrder(root.lNode);
            preOrder(root.rNode);

        }
    }

    //中序遍历
    public void midOrder(TreeNode root){
        if (root != null){
            midOrder(root.lNode);
            System.out.print(root.item + " ");
            midOrder(root.rNode);
        }

    }

    //后序遍历
    public void laterOrder(TreeNode root){
        if (root != null){
            laterOrder(root.lNode);
            laterOrder(root.rNode);
            System.out.print(root.item + " ");
        }
    }

    //BFS
    public void BFS(TreeNode root){
        //1.创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();

        //2.将root加入队列，队列不为空的时候循环
        queue.add(root);



        while(!queue.isEmpty()){
            //3.队头元素出队，并访问值

            TreeNode node = queue.remove();
            System.out.print(node.item +" ");


            //4.访问左子树，有则入队
            if (node.lNode != null){
                queue.add(node.lNode);

            }

            //5.访问右子树，有则入队

            if (node.rNode != null ){
                queue.add(node.rNode);
            }

        }

    }








}





