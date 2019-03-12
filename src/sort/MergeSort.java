package sort;

public class MergeSort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        mergesort(x,0,x.length-1);
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    //归并排序算法
    public static void mergesort(int[] arr,int low,int high)
    {
        if(low<high) {

            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            Merge(arr, low, mid, high);
        }
    }
    public static void Merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k=0;
        while(i<=mid&&j<=high){
            if(arr[i]<arr[j])
            {
                temp[k++]=arr[i++];
            }else
            {
                temp[k++]=arr[j++];
            }
        }
        //如果某一侧已经完成在原数组中的排序，则把另一侧的元素放入原数组
        while(i<=mid)
        {
            temp[k++]=arr[i++];
        }
        while(j<=high)
        {
            temp[k++]=arr[j++];
        }

        for(int m =0;m < temp.length ; m++)
        {
            arr[m+low]=temp[m];
        }
    }
}
