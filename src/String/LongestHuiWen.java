package String;
/*
 * author yfq
 * Time 2019.8.16
 * 最长回文子串
 * 思路：1，讲字符串划分为0-length长度的子串，去重，然后判断是不是回文
 *      2，参考最长公共子串或者最长公共子序列的思路，借助辅助矩阵实现。这里用辅助矩阵实现。
 */
public class LongestHuiWen {
    public static  void main(String[] args)
    {
        System.out.println(LHW("aacdefcaa"));
    }
    public static String LHW(String a)
    {
        int m = a.length();
        if(m==0)
            return a;
        //构建辅助矩阵
        int[][] array = new int[m+1][m+1];
        char[] array1 = a.toCharArray();
        char[] array2 = new char[m];
        //得到逆序字符串
        for(int i=0;i<m;i++)
        {
            array2[i] = array1[m-i-1];
        }
        for(int i = 0;i<m;i++)
        {
            for(int j= 0 ;j<m;j++)
            {
                if(array1[i]==array2[j])
                {
                    array[i+1][j+1] = array[i][j]+1;
                }
            }
        }
        //查找到最长的序列的位置
        //最长公共子串后，并不一定是回文串，我们还需要判断该字符串倒置前的下标和当前的字符串下标是不是匹配。
        int max = 0;// 最长回文串的长度
        int r = 0;
        int l = 0;// 记录位置
        for(int i = 1;i<m+1;i++)
        {
            for(int j = 1;j<m+1;j++)
            {
                if(array[i][j]>max) {
                    int beforeRev = m  - j;
                    if (beforeRev + array[i][j]  == i) { //判断下标是否对应
                        max = array[i][j];
                        r = i;
                    }
                }
            }
        }
        // 从array1 中剥离出所要字符串
        int start  = r-max;
        String finalString = a.substring(start,start+max);
        // 判断得到的字符串是否是回文 从中裁剪

        while(finalString.charAt(0)!=finalString.charAt(finalString.length()-1))
        {
            finalString = finalString.substring(0,finalString.length()-1);
        }

        return finalString;

    }
}
