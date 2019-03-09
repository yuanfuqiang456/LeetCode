package Array;
/*
 * author yfq
 * Time 2019.3.9
 * 字符数组中所有元素的排列。
 */
public class Permutation {
    public static void main(String[] args)
    {
        String s  = "abc";
        char[] a = s.toCharArray();
        permutation(a,0,3);
    }
    public static void swap(char[] arr,int idx1,int idx2){
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static void permutation(char[] arr,int index,int size){
        if(index == size){
            for(int i = 0;i<arr.length;i++){
                System.out.print(arr[i]+ "");
            }
            System.out.println();
        }
        else{
            for(int i = index;i<size;i++){
                swap(arr,i,index);    //我们从index向后扫描每一个字符（即指针i指向的字符），交换index和i指向的字符 //有一个需要判断的就是重复问题 如果字符相同就不交换了
                permutation(arr,index+1,size);  //对index后面的字符数组递归地做排列操作
                swap(arr,i,index);  //每次递归固定要排列字符数组第一个字符不变
            }
        }
    }
}
