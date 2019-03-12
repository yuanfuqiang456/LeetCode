package StackAndQueue;
import java.util.*;
//栈的压入 弹出序列 压栈元素均不相countOne.java
//MovingCount.java
//MatrixPath.java
//singleTon_2.java
//FibonacciList.java等
public class PopAndPushSeq {
    public static void main(String[] args)
    {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        l1.add(1);l1.add(2);l1.add(3);l1.add(4);l1.add(5);
        l2.add(4);l2.add(5);l2.add(3);l2.add(2);l2.add(1);
        l2.add(4);l2.add(3);l2.add(5);l2.add(2);l2.add(1);
        System.out.println(IsPopOrder(l1,l3));
    }
    public static boolean IsPopOrder(ArrayList<Integer> pushA,ArrayList<Integer> popA) {
        if(pushA.size()!=popA.size()){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j=0;
        for(int i=0;i<pushA.size();i++){
            stack.push(pushA.get(i));
            while((!stack.empty())&&(stack.peek()==popA.get(j))){
                stack.pop();
                j++;
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
