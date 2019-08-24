package String;

import java.util.ArrayList;

/*
 * author yfq
 * Time 2019.8.24
 * 将一个字符串Z字形打印。
 */
public class ZString {
    public static void main(String[] args)
    {
        String s1 = "LEETCODEISHIRING";
        int numRows1 = 3;
        String s2 = "LEETCODEISHIRING";
        int numRows2 = 4;
        String s3 = "A";
        int numRows3 = 1;
        //System.out.println(convert(s1,numRows1));
        System.out.println(convert(s3,numRows3));
    }
    public static String convert(String s, int numRows) {
        if(s.length() == 0)
            return "";
        if(numRows == 1)
            return s;
        int n = numRows - 1;
        char[] array = s.toCharArray();
        ArrayList<Character>[] array1 = new ArrayList[numRows];
        for(int i = 0;i<numRows;i++)
            array1[i] = new ArrayList<Character>();
        int i = 0;
        int m = 0;
        while(m<array.length) a:
        {
            for(int j = 0;j<n; j++) {
                if (i % n == 0) {
                    for (int k = 0; k < numRows; k++) {
                        if(m>=array.length)
                        {
                            break a;
                        }
                        else {
                            array1[k].add(array[m]);
                            m++;
                        }
                    }
                }
                else {
                    if(m>=array.length)
                    {
                        break a;
                    }
                    else {
                        array1[n - j].add(array[m]);
                    }
                    m++;
                }
                i++;
            }
        }
        String finallyString = "";
        for(int j = 0;j<numRows;j++)
        {
            for(int k = 0;k<array1[j].size();k++)
                finallyString += array1[j].get(k);
        }
        return finallyString;
    }
}
