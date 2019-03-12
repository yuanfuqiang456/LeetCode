package DynamicProgramming;
import java.util.List;
import java.util.Scanner;
//求计数值的最大值 给定一组数和一个子数字大小，求子数组最大和
/*
5 输入数字的个是
1
2
3
4
5
3 子数组大小
结果 12
 */
public class MaxSum2 {
    public static int solve(Integer[] num, int m){
        Integer[] temp = new Integer[m];
        Integer[] max = new Integer[m];
        int length = num.length;
        for(int i = 0;i< length ;i++)
        {
            if(i + m <= length)
            {
                System.arraycopy(num,i,temp,0,m);
                if(max[0]== null || (max[0]!= null && getSum(max)<getSum(temp)))
                {
                    System.arraycopy(temp,0,max,0,m);
                }
            }

        }
        int sum = 0;
        for(int i = 0;i<max.length;i++)
        {
            sum += max[i];

        }
        return sum;
        //return Arr ays.toString(max);
    }
    public static<T> Integer getSum(T t)
    {
        int sum = 0;
        if(t instanceof List<?>)
        {
            List<?> temp = (List<?>) t;
            int len = temp.size();
            for(int i = 0;i < len;i++)
            {
                sum += (Integer)temp.get(i);
            }
        }
        else if(t instanceof  Integer[])
        {
            Integer[] temp = (Integer[]) t;
            for(int i = 0;i < temp.length;i++)
            {
                sum += temp[i];
            }
        }
        return sum;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _num_size = 0;
        _num_size = Integer.parseInt(in.nextLine().trim());
        Integer[] _num = new Integer[_num_size];
        int _num_item;
        for(int _num_i = 0; _num_i < _num_size; _num_i++) {
            _num_item = Integer.parseInt(in.nextLine().trim());
            _num[_num_i] = _num_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());
        //List<Integer> lists = Arrays.asList(_num);

        res = solve(_num, _m);
        System.out.println(String.valueOf(res));

    }
    /*
    另一个思路 ，i从0-（length1 -length2）
    j 从 length2 - length1
    求i - j 的和
     */
}
