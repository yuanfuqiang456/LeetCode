package Tree;
import java.util.*;
//已知先序遍历和终中序遍历 新建二叉树
/*
 *已知先序遍历 第一个元素为根节点 在中序遍历中找到这个点（前提是这个二叉树中没有用重复的点）
 *在中序遍历中，该点前方序列为左子树 后方序列为右子树
 *遍历求解
 *同时包含了树的遍历、输出等方法
 */

 class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(){

    }
    public BinaryTreeNode(int value){
        this.value = value ;
        this.leftNode = null;
        this.rightNode = null;
    }

}
public class RebuildTree {
    public static void main(String[] args)
    {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        int[] postOrder = {5,7,6,9,11,10,8};
        //printPreOrder1(Construct(preOrder, inOrder, preOrder.length));
        //printPreOrder2(Construct(preOrder, inOrder, preOrder.length));
        //printInOrder1(Construct(preOrder, inOrder, preOrder.length));
        //printInOrder2(Construct(preOrder, inOrder, preOrder.length));
        //printPostOrder1(Construct(preOrder, inOrder, preOrder.length));
        //printPostOrder2(Construct(preOrder, inOrder, preOrder.length));
        //PrintFromTop2(Construct(preOrder, inOrder, preOrder.length));
        //System.out.println(VertifyQequence(postOrder,0,postOrder.length));
        FindPath(Construct(preOrder, inOrder, preOrder.length),14);

    }
    //前序遍历的递归实现
    public static void printPreOrder1(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
        }

        if (root.leftNode != null) {
            printPreOrder1(root.leftNode);
        }

        if (root.rightNode != null) {
            printPreOrder1(root.rightNode);
        }
    }
    //前序遍历的非递归实现
    public static void printPreOrder2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
             while(p!=null||!s.empty())
                 {
                     while(p!=null)
                         {
                             System.out.println(p.value);
                             s.push(p);
                             p = p.leftNode;
                         }
                     if(!s.empty())
                        {
                             p= s.lastElement();
                             s.pop();
                             p=p.rightNode;
                         }
                 }
    }
    //中序遍历的递归实现
    public static void printInOrder1(BinaryTreeNode root) {
        if (root != null) {

            if (root.leftNode != null) {
                printInOrder1(root.leftNode);
            }
            System.out.print(root.value + " ");

            if (root.rightNode != null) {
                printInOrder1(root.rightNode);
            }
        }



    }
    //中序遍历的非递归实现
    public static void printInOrder2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        while(p!=null||!s.empty())
        {
            while(p!=null)
            {
                s.push(p);
                p = p.leftNode;
            }
            if(!s.empty())
            {
                p= s.lastElement();
                System.out.println(p.value);
                s.pop();
                p=p.rightNode;
            }
        }
    }
    //后序遍历的递归实现
    public static void printPostOrder1(BinaryTreeNode root) {
        if (root != null) {

            if (root.leftNode != null) {
                printPostOrder1(root.leftNode);
            }


            if (root.rightNode != null) {
                printPostOrder1(root.rightNode);
            }
            System.out.print(root.value + " ");
        }
    }
    //后序遍历的非递归实现
    /*
    要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
    如果P不存在左孩子和右孩子，则可以直接访问它；
    或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，
    则同样可以直接访问该结点。
    若非上述两种情况，则将P的右孩子和左孩子依次入栈，
    这样就保证了 每次取栈顶元素的时候，左孩子在右孩子前面被访问，
    左孩子和右孩子都在根结点前面被访问。
     */
    public static void printPostOrder2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode cur ;
        BinaryTreeNode pre = null;
        s.push(root);
        while(!s.empty())
        {
                     cur=s.lastElement();
                     if((cur.leftNode==null&&cur.rightNode==null)||
                            (pre!=null&&(pre==cur.leftNode||pre==cur.rightNode)))
                     {
                         System.out.println(cur.value);  //如果当前结点没有孩子结点或者孩子节点都已被访问过
                         s.pop();
                         pre=cur;
                     }
                     else
                    {
                         if(cur.rightNode!=null)
                                 s.push(cur.rightNode);
                         if(cur.leftNode!=null)
                                 s.push(cur.leftNode);
                     }
                 }
         }



    //构建二叉树
    public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder,int length){
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        try {
            return ConstructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,inOrder.length - 1);
        } catch (InvalidPutException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static BinaryTreeNode ConstructCore(int[] preOrder,int startPreIndex, int endPreIndex,
                                               int[] inOrder,int startInIndex, int endInIndex) throws InvalidPutException {

        int rootValue = preOrder[startPreIndex];
        System.out.println("rootValue = " + rootValue);
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        // 只有一个元素
        if (startPreIndex == endPreIndex) {
            if (startInIndex == endInIndex
                    && preOrder[startPreIndex] == inOrder[startInIndex]) {
                System.out.println("only one element");
                return root;
            } else {
                throw new InvalidPutException();
            }
        }

        // 在中序遍历中找到根结点的索引
        int rootInIndex = startInIndex;

        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            ++rootInIndex;
        }

        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new InvalidPutException();

        }

        int leftLength = rootInIndex - startInIndex;

        int leftPreOrderEndIndex = startPreIndex + leftLength;

        if (leftLength > 0) {
            // 构建左子树
            root.leftNode = ConstructCore(preOrder, startPreIndex + 1,
                    leftPreOrderEndIndex, inOrder, startInIndex,
                    rootInIndex - 1);
        }

        if (leftLength < endPreIndex - startPreIndex) {
            // 右子树有元素,构建右子树
            root.rightNode = ConstructCore(preOrder, leftPreOrderEndIndex + 1,
                    endPreIndex, inOrder, rootInIndex + 1, endInIndex);
        }
        return root;
    }
    static class InvalidPutException extends Exception {

        private static final long serialVersionUID = 1L;

    }
    /*
    Queue使用时要尽量避免Collection的add()和remove()方法，
    而是要使用offer()来加入元素，使用poll()来获取并移出元素。
    它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。
    如果要使用前端而不移出该元素，使用
    element()或者peek()方法。

    值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
     */
    public static void PrintFromTop(BinaryTreeNode root)
    {
        if(root==null)
        {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(queue.size()!=0)
        {
            BinaryTreeNode node = queue.peek();
            System.out.println(node.value);
            queue.poll();
            if(node.leftNode!=null)
            {
                queue.offer(node.leftNode);
            }
            if(node.rightNode!=null)
            {
                queue.offer(node.rightNode);
            }
        }
    }
    //按行打印出来
    public static void PrintFromTop2(BinaryTreeNode root)
    {
        if(root==null)
        {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        int nextval = 0;
        int nowval = 1;
        while(queue.size()!=0)
        {
            BinaryTreeNode node = queue.peek();
            System.out.print(node.value);
            //queue.poll();
            if(node.leftNode!=null)
            {
                queue.offer(node.leftNode);
                nextval++;
            }
            if(node.rightNode!=null)
            {
                queue.offer(node.rightNode);
                nextval++;
            }
            queue.poll();
            --nowval;
            if(nowval==0)
            {
                System.out.println();
                nowval = nextval;
                nextval = 0;
            }
        }
    }
    //判断一个序列是不是二叉搜索树的后序遍历
    /*
    后序遍历，最后一个元素一定是根节点 左子树节点数字都小于根节点 右子树节点数字都大于根节点
     */
    public static boolean VertifyQequence(int[] seq,int start,int length)
    {
        if(seq==null || length<0 ||start >= length)
            return false;
        int root = seq[length-1];
        int i = start;
        //找到左子树
        for(;i<length;i++)
        {
            if(seq[i]>root)
                break;
        }
        int j = i;
        //找到右子树
        for(;j<length-1;j++)
        {
            if(seq[j]<root)
                return false;
        }
        //判断左子树是否满足后续遍历
        boolean left = true;
        if(i>1)
        VertifyQequence(seq,start,i);
        //判断右子树是否满足后序遍历
        boolean right = true;
        if(i<length-1)
        VertifyQequence(seq,i,length - i -1);
        return left&&right;
    }
    //打印和为某一数值的路径
    static int currentsum = 0;
    public static void FindPath(BinaryTreeNode root,int sum)
    {
        if(root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        findPath(root,sum,stack);
    }
    public static void findPath(BinaryTreeNode root,int k,Stack<Integer> path){
        if(root == null)
            return;
        if(root.leftNode == null && root.rightNode == null){
            if(root.value == k){
                System.out.println("路径开始");
                for(int i :path)
                    System.out.print(i+",");
                System.out.print(root.value);
            }
        }
        else{
            path.push(root.value);
            findPath(root.leftNode,k-root.value,path);
            findPath(root.rightNode,k-root.value,path);
            path.pop();
        }
    }
}
