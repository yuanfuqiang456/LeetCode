package others;
//计算十进制数转二进制数之后1的个数
public class countOne {
    public static void main(String[] args)
    {
        int data = 8;
        int count = NumberOf1_2(data);
        System.out.println(4&3);
        System.out.println(IsTwoPow(data));
        System.out.println(ChangeNum(10,13));
    }
    //整数右移一位和除以2是相同的 但是位移操作明显比除法操作效率高
    /*
    存在一个问题：该方法只能处理正数，无法处理负数
    如：0x80000000 右移一位，会保持符号位 变为）0xC0000000 而不是 ox40000000
    如果一直做右移，会死循环，变为0xFFFFFFF
     */
    public static int NumberOf1_1(int n)
    {
        int count = 0;
        while(n!=0)
        {
            if((n&1)!=0) {
                count++;
            }
                n = n >>1;
        }
        return count;
    }
    //为了避免死循环 左移
    public static int NumberOf1_2(int n)
    {
        int count = 0;
        int flag = 1;
        while(flag!=0)
        {
            if((n&flag)!=0)
                count++;
            flag = flag<<1;
        }
        return count;
    }
    //把一个整数减去1，和这个整数做与运算，那么该整数二进制的坐右边0变成1 ，有多少个整数就可以有多少次这个运算
    public static int NumberOf1_3(int n)
    {
        int count = 0;
        while(n!=0)
        {
            ++count;
            n = (n-1)&n;
        }
        return count;
    }
    //判断一个数是不是2的次方
    public static boolean IsTwoPow(int m)
    {
        boolean flag = false ;
        if((m&(m-1))==0)
        {
            flag = true;
        }
        return flag;
    }
    //判断一个数变为另一个数需要变的位数（二进制）
    public static int ChangeNum(int m,int n)
    {
        int count = 0;
        int a = m^n;
        count = NumberOf1_3(a);
        return count ;

    }
}
