package String;
import java.util.*;
/*
 * author yfq
 * Time 2019.3.9
 * 括号匹配加改变一组括号，使整个字符串匹配
 */
public class KuoHao {
    //改变一组括号位置，使字符串满足括号匹配
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String[] s = new String[m];
        in.nextLine();
        for(int i = 0; i <m; i++)
        {
            s[i] = in.nextLine();
        }
        for(int i = 0 ;i < m;i++)
        {
            int count = 0;
            String temp = s[i];
            int length  = temp.length();
            //char[] c = temp.toCharArray();
            for(int j = 0; j<length-1;j++) {
                for (int k = j+1; k <length; k++) {
                    char[] c = temp.toCharArray();
                    char tem = c[j];
                    c[j] = c[k];
                    c[k] = tem;
                    if(judgeMent(c))
                    {
                        count++;
                    }
                }
            }
            if(count!=0)
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }
    }
    public static boolean judgeMent(char[] c)
    {
        Stack<Character> s = new Stack<Character>();
        for(int i = 0;i<c.length;i++)
        {
            if(c[i]==')'&&!s.isEmpty()&&s.peek()=='(')
            {
                s.pop();
            }
            else
            {
                s.push(c[i]);
            }
        }
        if(s.size()==0)
            return true;
        else
            return false;
    }


}
