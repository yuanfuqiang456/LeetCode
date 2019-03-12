package String;
/*
 * author yfq
 * Time 2019.3.9
 *翻转字符串
 */
public class ReverseString {
    public static void main(String[] args){
        String s = "I am a student.";
        char[] c = s.toCharArray();
        int len = c.length;
        swap(c,0,c.length);
//        for(int i = 0;i<len/2;i++)
//        {
//            char tem = c[i];
//            c[i] = c[len-1-i];
//            c[len-1-i] = tem;
//        }
        System.out.println(c);
        //各个单词翻转
        int begin = 0;
        int end;
        for(end = 0;end<len;end++)
        {
            if(c[end]==' ')
            {
                swap(c,begin,end);
                begin = end+1;
            }
        }
        System.out.println(c);

    }
    public static void swap(char[] c,int begin,int end)
    {
        //int len = end - begin;
        for(int i = begin;i<(end+begin)/2;i++)
        {
            char tem = c[i];
            c[i] = c[end-1-i+begin];
            c[end-i-1+begin] = tem;
        }
    }
}
