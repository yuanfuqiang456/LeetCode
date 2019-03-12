package others;

public class MovingCount {

    public static void main(String[] args)
    {
        RebootStep r = new RebootStep();
        System.out.println(r.movingCount(5,4,4));
    }

}
class RebootStep
{
    //记录到达的格子数
    int count = 0;
    public  int movingCount(int threshold, int rows, int cols)
    {
        //边界条件判断
        if(rows<=0||cols<=0){
            return 0;
        }
        //建立一个判断矩阵
        boolean[] temp=new boolean[rows*cols];

        moving(rows,cols,temp,0,0,threshold);

        return count;
    }

    public  void moving(int rows,int cols,boolean[] temp,int i,int j,int k){

        if(check(rows,cols,i,j,k,temp)){
            count++;
            temp[i*cols+j]=true;
        }else{
            return;
        }
        moving(rows,cols,temp,i-1,j,k);
        moving(rows,cols,temp,i,j+1,k);
        moving(rows,cols,temp,i+1,j,k);
        moving(rows,cols,temp,i,j-1,k);


    }

    //判断机器人能否进入坐标为（i,j）的位置
    public boolean check(int rows,int cols,int i,int j,int k,boolean[] temp){

        if(i<0||i>=rows||j<0||j>=cols||temp[i*cols+j]==true||((getDigitSum(i)+getDigitSum(j))>k)){
            return false;
        }

        return true;

    }

    //得到一个数的数位之和
    public int getDigitSum(int num){

        int sum=0;
        while(num>0){

            sum+=num%10;
            num/=10;
        }

        return sum;
    }
}
