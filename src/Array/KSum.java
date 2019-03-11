package Array;

import java.util.ArrayList;
import java.util.Stack;

/*
 * author yfq
 * Time 2019.3.11
 * 和为定值的多个数 个数不定 输出数组中的所有组合
 */
public class KSum {
    static int[] nums = {3,4,1,2, 7, 9,11, 15};
    static int num = nums.length;
    public static void main(String[] args) {
        int target = 9;
        Stack<Integer> s = new Stack<>();
        for(int i= 1;i<=num;i++)
        {
            SumOfkNumber(s,target,i,0);
        }

    }
    /*
     * k 代表数组中需要选取的元素个数
     * start 代表从从数组中哪个元素开始
     */
    public static void SumOfkNumber(Stack<Integer> s,int sum,int k,int start)
    {
        int data = nums[start];
        if(sum==0)
        {
            System.out.println(s.toString());
        }
        if(data<=sum&&start<num&&k>0)
        {
            s.push(data);
            SumOfkNumber(s,sum-data,k-1,start+1);
            s.pop();
            SumOfkNumber(s,sum,k-1,start+1);
        }

    }

}
/*
 * 这里通过递归算法求出了同一个数组中不同范围内不同个数和为定值的情况
 * 唯一不足的是，这里求出的结果很多是重复的，那么如何避免这种重复呢。
 * 可行的办法就是 把结果存下来，逐个遍历
 */