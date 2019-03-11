package Array;

/*
 * author yfq
 * Time 2019.3.11
 * 两个数组a[N]，b[N]，其中A[N]的各个元素值已知，现给b[i]赋值，b[i]= a[0]a[1]a[2]...*a[N-1]/a[i]；要求解b[i]，
 * 但是：
       1.不准用除法运算

       2.除了循环计数值，a[N],b[N]外，不准再用其他任何变量（包括局部变量，全局变量等）

       3.满足时间复杂度O(n)，空间复杂度O(1)。

       算法思路：题目要求b[i] = a[0]a[1]a[2]...a[N-1]/a[i] ，相当于求：a[0]a[1]a[2]a[3]...a[i-1]a[i+1]..a[N-1]，
       等价于除掉当前元素a[i]，其他所有元素(a[i]左边部分，和a[i]右边部分)的积。
 */
public class CalculateWithoutMultiplication {
    static int[] Calculate(int a[], int output[], int length)
    {
        int left = 1;
        int right = 1;
        for (int i = 0; i < length; i++)
            output[i] = 1;
        for (int i = 0; i < length; i++)
        {
            output[i] *= left;
            output[length - i - 1] *= right;
            left *= a[i];
            right *= a[length - i - 1];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,8};
        int[] b = new int[5];
        int[] c = Calculate(a,b,5);
        for(int i =0;i<5;i++)
            System.out.println(c[i]);

    }

}
