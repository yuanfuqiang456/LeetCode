package DynamicProgramming;
/*
背包问题主要是指一个给定容量的背包、若干具有一定价值和重量的物品，如何选择物品放入背包使物品的价值最大。
其中又分01背包和无限背包，这里主要讨论01背包，即每个物品最多放一个。而无限背包可以转化为01背包。
先说一下算法的主要思想，利用动态规划来解决。
每次遍历到的第i个物品，根据w[i]和v[i]来确定是否需要将该物品放入背包中。
即对于给定的n个物品，设v[i]、w[i]分别为第i个物品的价值和重量，C为背包的容量。
再令v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值。则我们有下面的结果：
（1），v[i][0]=v[0][j]=0;
（2），v[i][j]=v[i-1][j]   当w[i]>j
（3），v[i][j]=max{v[i-1][j],v[i-1][j-w[i]]+v[i]}  当j>=w[i]
 */
public class Bag0_1 {
    //二维数组法
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        int[] weight = {3, 5, 2, 6, 4}; //物品重量
//        int[] val = {4, 4, 3, 5, 3}; //物品价值
//        int m = 12; //背包容量
//        int n = val.length; //物品个数
//
//        int[][] f = new int[n+1][m+1]; //f[i][j]表示前i个物品能装入容量为j的背包中的最大价值
//        int[][] path = new int[n+1][m+1];
//        //初始化第一列和第一行
//        for(int i=0;i<f.length;i++){
//            f[i][0] = 0;
//        }
//        for(int i=0;i<f[0].length;i++){
//            f[0][i] = 0;
//        }
//        //通过公式迭代计算
//        for(int i=1;i<f.length;i++){
//            for(int j=1;j<f[0].length;j++){
//                if(weight[i-1]>j)
//                    f[i][j] = f[i-1][j];
//                else{
//                    if(f[i-1][j]<f[i-1][j-weight[i-1]]+val[i-1]){
//                        f[i][j] = f[i-1][j-weight[i-1]]+val[i-1];
//                        path[i][j] = 1;
//                    }else{
//                        f[i][j] = f[i-1][j];
//                    }
//                    //f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i-1]]+val[i-1]);
//                }
//            }
//        }
//        System.out.println(f[n][m]);
//
//    }
    //完全背包问题
    public static void main(String[] args){
        int[] weight = {3,4,6,2,5};
        int[] val = {6,8,7,5,9};
        int maxw = 10;
        int[] f = new int[maxw+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<val.length;i++){
            for(int j=weight[i];j<f.length;j++){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        System.out.println(f[maxw]);
    }

}
