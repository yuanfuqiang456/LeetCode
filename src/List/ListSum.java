package List;

/*
 * author yfq
 * Time 2018.12.27
 * LeetCode 题目2 两数之和
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 这里比较重要的是每个节点只能存储一位数字，简化了算法，和最多不会超过两位。
 * 可以借助栈来处理，把每个列表变为数字，求和，再变为列表
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 需考虑各种测试用例和结果 [0,10];[1,8][0]相加等；
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class ListSum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(3);
        l1.next = l2;l2.next = l3;
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;l5.next = l6;
        ListNode L = addTwoNumbers(l1,l4);
        while(L!=null)
        {
            System.out.println(L.val);
            L=L.next;
        }


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode l3 = l;
        while(l1!=null&&l2!=null)
        {
            ListNode l0 = new ListNode(0);
            l.val = l1.val +l2.val;
            l1 = l1.next;
            l2 = l2.next;
            l.next = l0;
            l = l.next;
        }
        if(l1!=null) {
            l.val = l1.val;
            l.next = l1.next;
        }
        else if(l2!=null) {
            l.val = l2.val;
            l.next = l2.next;
        }
        l=l3;
        while(l3.next!=null)
        {
            int m = 0;
            int n = 0;
            if(l3.val>=10)
            {
                m = l3.val/10;
                n = l3.val%10;
                l3.val = n;
                l3=l3.next;
                l3.val = l3.val+m;
            }
            else
            {
                l3 = l3.next;
            }

        }
        if(l3.next==null&&l3.val>=10)
        {
            ListNode l0 = new ListNode(0);
            l3.next = l0;
            int m = 0;
            int n = 0;
            m = l3.val/10;
            n = l3.val%10;
            l3.val = n;
            l3=l3.next;
            l3.val = l3.val+m;
        }
        if(l3.val ==0) {//去除最后一个节点
            l1 = l;
            l2 = l;
            l2 = l2.next;
            while(l2.next!=null){
                l1= l1.next;
                l2= l2.next;
            }
            l1.next = null;

        }



        return l;
    }
}
