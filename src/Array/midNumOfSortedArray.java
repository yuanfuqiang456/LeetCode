package Array;

import java.util.ArrayList;

/*
 * author yfq
 * Time 2019.07.21
 * 返回两个有序数组的中位数
 */
public class midNumOfSortedArray {
    public static void main(String[] args)
    {
        int[] num1={1,2,3};
        int[] num2={};
        //System.out.println(findMedianSortedArrays(num2,num1));
        int[] num3={1,2,3,4,5};
        int[] num4={2};
        System.out.println(findMedianSortedArrays(num3,num4));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<a&&j<b)
        {
            int m = nums1[i];
            int n = nums2[j];
            if(m>n) {
                list.add(n);
                j++;
            }
            else if(m<n)
            {
                list.add(m);
                i++;
            }
            else
            {
                list.add(m);
                list.add(n);
                i++;
                j++;
            }

        }
        if(i==a&&j!=b)
        {
            for(;j<b;j++)
                list.add(nums2[j]);
        }
        if(j==b&&i!=a)
        {
            for(;i<a;i++)
                list.add(nums1[i]);
        }
        int c = list.size();
        if(c%2==0)
        {
            return (0.0+list.get(c/2)+list.get(c/2-1))/2;
        }
        else
        {
            return list.get(c/2);
        }

    }
}
