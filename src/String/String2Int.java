package String;
/*
 * author yfq
 * Time 2019.3.12
 * 字符串转Int
 */
public class String2Int {
    public static void main(String[] args)
    {
        String s1 = "0";
        String s2 = "123";
        String s3 = "-123";
        System.out.println(string2int(s1));
        System.out.println(string2int(s2));
        System.out.println(string2int(s3));

    }
    public static int string2int(String str)
    {
        if(str==null || str.length() == 0){
            return 0;
        }
        int n = str.length(), s = 1;
        char[] chs = str.toCharArray();
        int res = 0;
        if(chs[0] == '-') s = -1;
        for(int i = (chs[0] ==  '-' || chs[0] == '+') ? 1 : 0; i < n; ++i){
            if(!('0' <= chs[i] && chs[i] <= '9')) return 0;
            res = (res << 1) + (res << 3) + (chs[i] & 0xf);//res=res*10+str[i]-'0';
        }
        return (int)res * s;
    }
}
