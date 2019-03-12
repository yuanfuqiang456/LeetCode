package others;
import java.math.*;
//质数定义:大于1的自然数中,只能被1和自身整除的数叫质数
//思路:自然数i和大于1小于自己的自然数j作取余运算i%j,若为质数,则i%j不会等于0
public class sushu {
  public static void main(String[] args) {
      // TODO Auto-generated method stub
      double j;
      boolean flag;
      double a = Math.pow(10,8);
      for(double i=2;i<a;i++){
          flag=false;
          for(j=2;j<=Math.sqrt(i);j++){//或者 i《=i/2s
              if(i%j==0){
                  flag=true;
                  break;
              }
          }
          if(flag==false){
              System.out.println(i);
          }
      }
  }
}
