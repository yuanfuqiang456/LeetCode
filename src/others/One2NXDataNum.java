package others;
//剑指offer43题 求 1-n 中X 出现的次数
/*
这里的 x 属于[1, 9]， 因为 x = 0 不符合下列规律，需要单独计算
首先要知道以下规律
从 1 至 10，在它们的个位数中，任意的 x 都出现了 1 次
从 1 至 100，在它们的十位数中，任意的 x 都出现了 10 次
从1至1000，在它们的百位数中，任意的x都出现了100次
依次类推，从 1 至 10i，在它们的左数第二位(右数第 i 位)，任意的 x 都出现了 (10i-1)次。这个规律很容易验证，这里不再多做说明
总结一下以上的算法，可以看到，当计算右数第 i 位包含的 x 的个数时：
取第 i位左边(高位)的数字，乘以 10i-1，得到基础值 a
取第 i 位数字，计算修正值
如果大于 x , 则结果为 a + 10i-1
如果小于 x，则结果为 a
如果等于 x，则取第 i 位右边(低位)数字，设为 b，最后结果为 a + b + 1
 */
public class One2NXDataNum {
    public static void main(String[] args)
    {
        int max = 100;
        int x = 1;
        String s ;
        
        System.out.println(NumCount(max,x));

    }
    public static int NumCount(int max,int x)
    {
        int count = 0;
        if(max<0)
            return 0;
        if(max<9)
            return 1;
        int k = 0;
        int cur = 0;
        int high = 0;


        for(int i = 1; i<=max; i *= 10){

            k = max/i;

            high = k / 10;

            count += high * i;

            cur = k % 10;
            if(cur > x)
                count += i;
            else if(cur == x)
                count += max - k * i + 1;
        }

        return count;
    }
}
/*
https://www.cnblogs.com/lengender-12/p/6876897.html
 */