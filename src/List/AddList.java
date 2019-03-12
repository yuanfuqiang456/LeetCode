package List;

import java.util.Scanner;
/*
 * author yfq
 * Time 2019.3.12
 * 两个链表相加
 */
class Node
{
    int data;
    Node next;
}
public class AddList {
    public static void main(String[] args){
        //生成第一个链表
        System.out.println("输入第一个链表第节点");
        Scanner sc  = new Scanner(System.in);
        //以下变量设置比较多，主要是为了在遍历列表之后仍可以访问头节点
        Node node0 = new Node();
        Node node1 = node0;
        while (true) {
            int num  = sc.nextInt();
            if (num == -1) break;
            else
            {
                Node node = new Node();
                node.data = num;
                node1.next = node;
                node1 = node;
            }
        }

        System.out.println("第一次链表输入完毕");
//        输出第一个列表的数据
//        Node node11 = node0;
//        while(node11.next!=null)
//        {
//            Node node = node11.next;
//            System.out.println(node.data);
//            node11 = node11.next;
//        }
        //生成第二个链表
        System.out.println("输入第二个链表第节点");
        Node node2 = new Node();
        Node node3 = node2;
        while (true) {
            int num  = sc.nextInt();
            if (num == -1) break;
            else
            {
                Node node = new Node();
                node.data = num;
                node3.next = node;
                node3 = node;
            }
        }
        System.out.println("第二次链表输入完毕");
//        输出第二个列表的数据
//        Node node4 =node2;
//        while(node4.next!=null)
//        {
//            Node  node = node4.next;
//            System.out.println(node.data);
//            node4 = node4.next;1
//        }
        node1 = node0;
        node3 = node2;
        Node node4 = new Node();
        Node node5 = node4;
        while(node1.next!=null&&node3.next!=null)//取公共部分相加
        {
            Node node = new Node();
            node.data = node1.next.data + node3.next.data;
            node4.next = node;
            node4 = node4.next;
            node1 = node1.next;
            node3 = node3.next;
        }
        while(node1.next!=null)//两个列表可能不一样长，将不一样长的部分加到结果列表的尾部
        {
            Node node = new Node();
            node.data = node1.next.data;
            node4.next = node;
            node4 = node4.next;
            node1 = node1.next;
        }
        while(node3.next!=null)
        {
            Node node = new Node();
            node.data = node3.next.data;
            node4.next = node;
            node4 = node4.next;
            node3 = node3.next;
        }
        node4 =node5; //为node4重新赋值 这样可以重用这个变量
        while(node5.next!=null) //大于10的节点做数字调整
        {
              Node  node = node5.next;
              int a = node.data%10;
              int b = node.data/10;
              if(node.data>=10)
              {
                  node.data = a;
                  if(node.next!=null)
                  {
                      node.next.data = node.next.data + b;
                  }
                  else
                  {
                      Node newnode = new Node();
                      newnode.data = b;
                      node.next = newnode;
                  }
              }
              //System.out.println(node.data);
              node5 = node5.next;
        }
        while(node4.next!=null)
        {
            Node node = node4.next;
            System.out.println(node.data);
            node4 = node4.next;
        }
    }
}
