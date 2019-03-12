package sort;

public class Count_sort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        System.out.println("Before sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
        //Quicksort(x,0,x.length-1);
        countsort(x,9);
        System.out.println("After sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    public static void countsort(int[] arr,int k)
    {
        //创建一个区间大小的数组，放置区间内数据的数量
        int[] countArray = new int[k + 1];
        //对区间内的各个数据进行计数
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            countArray[value] += 1;
        }
        //求区间内各个数据的位置
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        //创建临时输出数组，将数据放置到合适的位置上，从后往前遍历正
        //是为了保证算法的稳定性——原数组中相同元素的顺序即输出数组
        //中的顺序
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            int position = countArray[value] - 1;

            temp[position] = value;
            countArray[value] -= 1;
        }
        //替换原数组中的元素
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
