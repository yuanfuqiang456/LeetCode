package List;
import java.util.*;
// 剑指0offer 6题 从尾巴到头打印链表
public class PrintDes {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
         Stack<Integer> stack=new Stack<Integer>();
         //队列和栈，从尾到头打印链表，离不开借助栈
         //所以，先把链表里的东西，都放到一个栈里去，然后按顺序把栈里的东西pop出来
        while(listNode!=null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
         ArrayList<Integer> list=new ArrayList<Integer>();
         while(!stack.isEmpty()){ list.add(stack.pop()); } return list; }

        //递归方法 不足之处  当链表非常长当时候  函数调用栈会溢出
//        if (listNode != null)
//        {
//            printListFromTailToHead(listNode.next);
//            arrayList.add(listNode.val);
//        }
//        return arrayList;}
    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(0);
        System.out.println(printListFromTailToHead(listNode).toString());
    }
}
