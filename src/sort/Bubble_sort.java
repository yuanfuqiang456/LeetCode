package sort;

public class Bubble_sort {
    public static void main(String[] args){
        int[] x = {5,2,6,9,4};
        System.out.println("Before sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }

        bubblesort(x);
        System.out.println("After sort:");
        for(int y: x)
        {
            System.out.println(y+" ");
        }
    }
    public static void bubblesort(int[] arr) {
        for(int i = 0;i < arr.length-1;i++ )
        {
            for(int j = 0;j < arr.length -1 - i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }
}
