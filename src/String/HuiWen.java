package String;
/*
 * author yfq
 * Time 2019.3.9
 * 判断字符串是否是回文串
 */

public class HuiWen {
    public static  void main(String[] args)

    {
        System.out.println(huiwen("ab"));
    }
    public static boolean huiwen(String s)
    {
        char[] ch = s.toCharArray();
        int x = 0;
        int y = s.length()-1;
        while(x < y)
        {
            if(ch[x++] != ch[y--]){
                return false;
            }
        }
        return true;
    }
}
