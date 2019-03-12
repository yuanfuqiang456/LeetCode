package sort;
//基数排序 是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
public class Radix_sort {
    public static void main(String[] args) {
        int[] x = {90, 821, 7300, 6, 52, 47, 36, 29, 65, 11, 0};
        radixSort(x, 4);
        for (int y : x) {
            System.out.println(y + " ");
        }
    }
    public static void radixSort(int[] arr,int k) {
        int[][] array = new int[10][arr.length + 1];
        for (int i = 0; i < 10; i++) {
            array[i][0] = 0;// array[i][0]记录第i行数据的个数
        }
        for (int pos = 1; pos <= k; pos++) {
            for (int i = 0; i < arr.length; i++) {// 分配过程
                int row = getNumInPos(arr[i], pos);
                int col = ++array[row][0];
                array[row][col] = arr[i];
            }
            for (int row = 0, i = 0; row < 10; row++) {// 收集过程
                for (int col = 1; col <= array[row][0]; col++) {
                    arr[i++] = array[row][col];
                }
                array[row][0] = 0;// 复位，下一个pos时还需使用
            }
        }
    }
    /*
     * k为位数
     */
    public static int getNumInPos(int m,int k)
    {
        int tmp = 1;
        for (int i = 0; i < k - 1; i++) {
            tmp *= 10;
        }
        return (m / tmp) % 10;
    }
}
