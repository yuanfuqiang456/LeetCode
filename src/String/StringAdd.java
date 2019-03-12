package String;
//字符串相加

/*
大数运算
注意点:

大数相加的时候没有判断数字的正负，

如果都是正数，那么就可以按照正数相加来计算，

如果是一正一负可以转换成大整数相减，

两个负数可以先保存符号，然后相加。

大数相加不能直接使用基本的int类型，因为int可以表示的整数有限，不能满足大数的要求。可以使用字符串来表示大数，模拟大数相加的过程。
且都是正数
思路：

　　　　1.反转两个字符串，便于从低位到高位相加和最高位的进位导致和的位数增加；

       2.对齐两个字符串，即短字符串的高位用‘0’补齐，便于后面的相加；

       3.把两个正整数相加，一位一位的加并加上进位。
 */
public class StringAdd {
    public static void main(String[] args){
        System.out.println(add("100","5"));
    }
    /**
     * 用字符串模拟两个大数相加
     * @param n1 加数1
     * @param n2 加数2
     * @return   相加结果
     */
    public static String add(String str1,String str2)
    {if(str1 == null)
                     return str2;
                  if(str2 == null)
                      return str1;
                  StringBuffer s1 = new StringBuffer(str1).reverse();
                  StringBuffer s2 = new StringBuffer(str2).reverse();
                  StringBuffer res = new StringBuffer();
                  int len1 = s1.length();
                  int len2 = s2.length();
                  int len;
                  if(len1 < len2) {
                      len = len2;
                      int count = len2 - len1;
                      while(count-- > 0)
                              s1.append('0');
                  } else {
                      len = len1;
                      int count = len1 - len2;
                      while(count-- > 0)
                              s2.append('0');
                  }
                  int overflow = 0;
                  int num;
                  for(int i = 0; i < len; i++) {
                      num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
                      if(num >= 10) {
                              overflow = 1;
                              num -= 10;
                          } else {
                              overflow = 0;
                          }
                      res.append(String.valueOf(num));
                  }
                  if(overflow == 1)
                      res.append(1);

                  return res.reverse().toString();
    }
    public static String Sub(String f, String s) {
        System.out.print("减法:" + f + "-" + s + "=");
        // 将字符串翻转并转换成字符数组
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 找到最大长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];
        // 表示结果的正负
        char sign = '+';
        // 判断最终结果的正负
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            // 找到第一个不相等的
            // 注意下标0处理
            while (i > 0 && a[i] == b[i]) {
                i--;
            }
            if (a[i] < b[i]) {
                sign = '-';
            }
        }
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，
        // 然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要
        if (sign == '-') {
            sb.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        // 结果为一位且是0，被上面的for处理了
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        // 返回值
        System.out.println(sb.toString());
        return sb.toString();
    }
}
