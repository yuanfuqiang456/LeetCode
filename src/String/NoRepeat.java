package String;

import java.util.HashMap;

/*
 * author yfq
 * Time 2019.07.13
 * LeetCode 题目3 最长无重复子串
 * 输入: "abcabcbb"
 * 输出: 3
 */
public class NoRepeat {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aau";
        System.out.println(lengthOfLongestSubstring(s4));
    }

    public static int lengthOfLongestSubstring(String s) {
        //思路：选取从下标 a 开始无重复子串 然后换个起始位置
        int length = s.length();
        if(length ==0)
            return 0;
        if(length == 1)
            return 1;
        int max = 1;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0;i<=length;i++)
        {
            map.clear();
            for(int j = i+1;j<=length;j++) {
                String s1 = s.substring(j-1,j);
                if(map.get(s1)==null)
                {
                    map.put(s1,s1);
                    if(j==length)
                    {
                        String s2 = s.substring(i,j);
                        max = max>s2.length()?max:s2.length();
                        break;
                    }
                }
                else
                {
                    String s2 = s.substring(i,j-1);
                    max = max>s2.length()?max:s2.length();
                    break;
                }

            }

        }
        return max;


    }

}
