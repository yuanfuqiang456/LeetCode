package String;

/*
 * author yfq
 * Time 2019.3.12
 * 字符串裁剪案例
 */
import java.util.StringTokenizer;

public class Split {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer("Hello,happy,do,o,do",",");
        while(st.hasMoreElements())
        {
            System.out.println(st.nextElement());
        }

    }
}
