package Array;
import java.util.*;
/*
 * author yfq
 * Time 2019.3.11
 * 约瑟夫环
 */
public class JosephLink {
    static int finalPos(int num,int pos)
    {
        int p=0;
        for(int i=2;i<=num;i++)
        {
            p=(p+pos)%i;
        }
        return p+1;
    }
    public static void main(String[] args) {
        // write your code here
        Scanner s= new Scanner(System.in);
        System.out.print("输入总人数：");
        int Num = s.nextInt();

        System.out.print("输入删除位置：");
        int pos = s.nextInt();
        System.out.println(finalPos(Num,pos));

    }
}
