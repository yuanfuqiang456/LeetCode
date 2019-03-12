package sort;
/*
堆还经常被用来求一个数列中第K大的数。
只需要建立一个大小为K的最小堆，堆顶就是第K大的数。
如果求一个数列中第K小的数，只最需要建立一个大小为K的最大堆，
堆顶就是第K小的数，这种方法的时间复杂度是O(NlogK)。
当然你也可以用堆来求前K大的数和前K小的数。堆调整的时间复杂度是O(log n)
 */
public class HeapSort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        System.out.println("Before sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }

        heapsort(x);
        System.out.println("After sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    public static void heapsort(int[] arr)
    {
        //构建大顶堆

        //挨个输出
        Build_Max_Heap(arr);
        for(int i = arr.length-1;i>=1;i--)
        {
            swap(arr,0,i);
            Max_Heapify(arr,0);
        }
    }
    //构建大顶堆
    public static void Build_Max_Heap(int[] arr)
    {
        int half = arr.length-1 / 2;
        for (int i = half; i >= 0; i--) {
            Max_Heapify(arr, i);
        }
    }
    public static void swap(int[] data,int i,int j)
    {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
    public static void Max_Heapify(int[] arr,int index)
    {
        int left = index * 2+1;
        int right = index * 2+2;

        int largest = index;
        if (left < arr.length && arr[left] > arr[index]) {
            largest = left;
        }

        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(arr, index, largest);

            Max_Heapify(arr,largest);
        }
    }
}
