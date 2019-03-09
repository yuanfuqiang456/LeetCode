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
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class ListSum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;l5.next = l6;
        ListNode L = addTwoNumbers(l1,l4);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null;
        return l;
    }
}
