package sort;
//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int[] x = {5, 2, 6, 9, 4};
        System.out.println("Before sort:");
        for (int y : x) {
            System.out.println(y + " ");
        }
        shellsort(x);
        System.out.println("After sort:");
        for (int y : x) {
            System.out.println(y + " ");
        }
    }
    public static void shellsort(int[] arr)
    {
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                     while(j-gap>=0 && temp<arr[j-gap]){
                            //移动法
                            arr[j] = arr[j-gap];
                            j-=gap;
                            }
                            arr[j] = temp;
                     }
            }
        }
    }
}
