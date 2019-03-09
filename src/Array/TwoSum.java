package Array;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * author yfq
 * Time 2018.12.27
 * LeetCode 题目1 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 可以考虑循环遍历或者结合哈希表的方法，但是使用哈希表的过程中应该注意元素相同时候的情况（不如直接暴力法）
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] answer = twoSum(nums,target);
        for(int i = 0;i<answer.length;i++)
            System.out.println(answer[i]);

    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++)
        {
            hashmap.put(nums[i],i);
        }
        for (Entry<Integer, Integer> entry : hashmap.entrySet()) {
            Integer a = entry.getKey();
            Integer b = entry.getValue();
            if(a<target)
            {
                Integer c = hashmap.get(target-a);
                if(c!=null)
                {
                    answer[0] = b;
                    answer[1] = c;
                    return answer;
                }
            }
        }
        return answer;

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0;i<nums.length;i++)
        {
                //要考虑正负和存在0 的情况
                for(int j = i+1;j<nums.length;j++)
                {
                    if(nums[j]==target-nums[i])
                    {
                        answer[0]= i;
                        answer[1]= j;
                        return answer;
                    }
                }
        }

        return answer;

    }
}
