package StackAndQueue;
import java.util.*;
//剑指offer 含min 函数的栈
public class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> dataStack = new Stack<>();

    public void push(Integer item){
        dataStack.push(item);
        if(minStack.empty() || item<=minStack.lastElement()){
            minStack.push(item);
        }else{
            minStack.push(minStack.lastElement());
        }
    }
    public Integer pop(){
        if(dataStack.empty() || minStack.empty()){
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }
    public Integer min(){
        if(minStack.empty()){
            return null;
        }
        return minStack.lastElement();
    }
    public static void main(String[] args){
        MinStack test = new MinStack();
        test.push(3);
        test.push(2);
        test.push(1);
        test.push(5);
        System.out.println(test.pop());
        System.out.println(test.min());
    }
}
