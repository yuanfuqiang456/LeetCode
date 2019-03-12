package sort;

public class QuickSort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        Quicksort(x,0,x.length-1);
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    //快速排序算法
    public static void Quicksort(int[] arr,int low, int high)
    {
        if(low<high)
        {
            int m = Partition(arr,low,high);
            Quicksort(arr,low,m-1);
            Quicksort(arr,m+1,high);
        }

    }
    //找到划分位置
    public static int Partition(int[] arr,int low, int high)
    {
        int x = arr[high];
        int y = low-1;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<=x)
            {
                y=y+1;
                swap(arr,y,j);
            }
        }
        swap(arr,y+1,high);
        return y+1;
    }
    //数据调换
    public static void swap(int[] data, int i, int j)
    {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
}
