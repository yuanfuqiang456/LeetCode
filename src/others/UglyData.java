package others;
//丑数
public class UglyData {
    public static void main(String[] args)
    {
        int[] uglydata = new int[1500];
        int mul2flag = 0;
        int mul3flag = 0;
        int mul5flag = 0;
        //int nowindex = 0;
        uglydata[0] = 1;
        for(int i =1 ;i<1500;i++)
        {
            uglydata[i] = min(uglydata[mul2flag]*2,uglydata[mul3flag]*3,uglydata[mul5flag]*5);
            while(uglydata[i]>=uglydata[mul2flag]*2)
            {
                mul2flag++;
            }
            while(uglydata[i]>=uglydata[mul3flag]*3)
            {
                mul3flag++;
            }
            while(uglydata[i]>=uglydata[mul5flag]*5)
            {
                mul5flag++;
            }
            System.out.println(uglydata[i]);
        }

    }
    public static int min(int a,int b,int c)
    {
        int min = a>b?b:a;
        return min<c?min:c;
    }
}
