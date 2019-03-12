package others;
//剑指offer 12 题 回溯法 求矩阵中是否存在某一路径
public class MatrixPath {
    public static void main(String[] args)
    {
        String s1 = "abcesfcsadee";
        String s2 = "abcb";
        String s3 = "bcced";
        System.out.println(hasPath(s1.toCharArray(),3,4,s2.toCharArray()));
        System.out.println(hasPath(s1.toCharArray(),3,4,s3.toCharArray()));
    }

    /**
     * 判断字符矩阵是否包含某一个字符序列
     * @param matrix
     * @param rows  矩阵行数
     * @param cols  矩阵列数
     * @param str   目标字符序列
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean visitFlags[] = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, 0, visitFlags))
                    return true;
            }
        }

        return false;
    }

    /**
     * 回溯法递归实现判断
     * @param matrix    字符矩阵
     * @param rows  矩阵行数
     * @param cols  矩阵列数
     * @param row   当前行索引
     * @param col   当前列索引
     * @param str   目标字符序列
     * @param k 目标字符序列中当前字符索引
     * @param visitFlags    字符矩阵是否被访问过标记
     * @return
     */
    public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str,  int k, boolean[] visitFlags) {
        int index = row * cols + col;
        // 行列索引超限、当前字符已经被访问过、当前字符不等于目标字符序列的当前字符，直接返回false
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
                visitFlags[index] || matrix[index] != str[k])
            return false;

        visitFlags[index] = true;   // 设置访问标记
        if (k == str.length - 1)    // 递归结束条件，k已经到达目标字符序列的最后一个字符
            return true;

        k++;    // 匹配目标字符序列的下一个字符

        // 在当前字符的上、下、左、右的元素搜索下一个目标字符，递归
        if (hasPathCore(matrix, rows, cols, row + 1, col, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row - 1, col, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, k, visitFlags) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, k, visitFlags))
            return true;

        // // 在当前字符的上、下、左、右的元素没有搜索到下一个目标字符，将访问标记重置为false，返回false；
        visitFlags[index] = false;
        return false;
    }
}
