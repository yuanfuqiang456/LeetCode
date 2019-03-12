package String;

public class KMP {
    //可以实现复杂度为O(m+n)
    /*
    一个基本事实是，当空格与D不匹配时，
    你其实知道前面六个字符是"ABCDAB"。
    KMP算法的想法是，设法利用这个已知信息，
    不要把"搜索位置"移回已经比较过的位置，
    继续把它向后移，这样就提高了效率。
    －　"A"的前缀和后缀都为空集，共有元素的长度为0；
    －　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
    －　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
    －  "ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素长度为 0；
    －　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
    －　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
    －　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为        [BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
    "部分匹配"的实质是，有时候，字符串头部和尾部会有重复。
    比如，"ABCDAB"之中有两个"AB"，那么它的"部分匹配值"就是2（"AB"的长度）。
    搜索词移动的时候，第一个"AB"向后移动4位（字符串长度-部分匹配值），就可以来到第二个"AB"的位置。
     */
    public static void main(String[] args)
    {
        String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);
        int res = kmp(b, a,next);
        System.out.println(res);
        for(int i = 0; i < next.length; i++){
            System.out.println(next[i]);
        }
        System.out.println(next.length);
    }
    public static int kmp(String str, String dest,int[] next){//str文本串  dest 模式串
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return 0;
    }
    //计算next数组
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
