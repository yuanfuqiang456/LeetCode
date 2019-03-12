package others;

public class FibonacciList {
    public static void main(String[] args){
        System.out.println(Fibonacci1(9));
    }
    //简单递归  效率低 重复计算多
    public static int Fibonacci0(int m)
    {
        if(m<= 0)
            return 0;
        if(m == 1)
            return 1;
        return Fibonacci0(m-1) + Fibonacci0(m-2);
    }
    //改进算法
    public static int Fibonacci1(int m)
    {
        int firstnum  = 1;
        int secodnum = 2;
        int result = 0;
        for(int i = 2;i <=m ;i++)
        {
            result = firstnum + secodnum;
            firstnum = secodnum;
            secodnum = result;
        }
        return result;
    }
}
