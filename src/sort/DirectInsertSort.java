package sort;
//直接插入排序 从后边序列拿一个插入到前方有序序列中
public class DirectInsertSort {
    public static void main(String[] args)
    {
        int[] x = {5,2,6,9,4};
        System.out.println("Before sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
        //
        insertsort(x);
        System.out.println("After sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    public static void insertsort(int[] arr)
    {
        int i,j;
        int n= arr.length;
        int key;

        for(j=1;j<n;j++)
        {
            key = arr[j];
            i=j-1;
            while(i>=0&&arr[i]>key)
            {
                arr[i+1]=arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }
}
