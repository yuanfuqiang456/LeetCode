package DynamicProgramming;
//最大子段和 子段大小不限制
public class MaxSum1 {
    public static void main(String[] args)
    {
        int[] arr = { 2,5,-3,4,-9,44,32,22,11,-30 };
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("====================");
        maxSumDp(arr);
    }
    // 最大子段和动态规划法实现 b[j]=max{b[j-1]+a[j]，a[j]}  b[1]=A[1]
    public static void maxSumDp(int[] arr) {
        int sum = 0, b = 0, n = arr.length, bestx = 0, besty = 0;
        for (int i = 1; i <= n; i++) {
            if (b > 0) {
                b += arr[i - 1];
            } else {
                b = arr[i - 1];
                bestx = i;
            }
            if (b > sum) {
                sum = b;
                besty = i;
            }
        }
        System.out.println("动态规划算法最优值：" + sum);
        System.out.println("最优解：" + bestx + "-->" + besty);
    }
}
