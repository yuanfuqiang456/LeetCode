package sort;
//选择排序
public class SelectSort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        System.out.println("Before sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }

        selectsort(x);
        System.out.println("After sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    public static void selectsort(int[] arr)
    {
        for(int i = 0;i<arr.length;i++)
        {
            int min = i;
            for(int j = i+1;j<arr.length;j++ )
            {
                if(arr[min]>arr[j])
                    min = j;
            }
            if(min!=i)
            {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
