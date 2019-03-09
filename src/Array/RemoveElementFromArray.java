package Array;

import java.util.ArrayList;

/*
 * author yfq
 * Time 2019.3.9
 * 题目要求 删除有序数组中的重复元素 返回新数组的长度。
 */
public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 4,6,7,9};
        System.out.println(REFA(nums));

    }
    public static int REFA(int[] Array)
    {
        ArrayList<Integer> newArray = new ArrayList<>();
        int index = 0;
        System.out.println(newArray.size());
        if(Array.length<=1)
            return Array.length;
        for(int i = 0;i<Array.length;i++)
        {
            if(Array[index]!=Array[i])
            {
                index = i;
                newArray.add(Array[i]);
            }
        }

        return newArray.size();
    }
}
